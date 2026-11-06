package ec.edu.uisek.githubclient.ui.viewmodels

import ec.edu.uisek.githubclient.models.Repository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ec.edu.uisek.githubclient.services.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RepoListViewModel: ViewModel()  {
    private val _repos = MutableStateFlow<List<Repository>>(value=emptyList())
    val repos: StateFlow<List<Repository>> = _repos.asStateFlow()

    private val _isLoading = MutableStateFlow(value=false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errorMsg = MutableStateFlow<String?>(value=null)
    val errorMsg: StateFlow<String?> = _errorMsg.asStateFlow()
    val errorMessage: StateFlow<String?> = _errorMsg.asStateFlow()

    init {
        fetchRepos()
    }

    fun fetchRepos() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMsg.value = null
            try {
                _repos.value = RetrofitClient.apiService.getRepositories()
            }catch (e: Exception) {
                _errorMsg.value = "Error al cargar los repositorios: ${e.localizedMessage}"
            }finally {
                _isLoading.value = false
            }

        }
    }
}
