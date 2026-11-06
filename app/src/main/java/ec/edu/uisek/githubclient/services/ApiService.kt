package ec.edu.uisek.githubclient.services

import ec.edu.uisek.githubclient.models.Repository
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("user/repos")
    suspend fun getRepositories(
        @Query(value = "sort") sort: String = "created",
        @Query(value = "direction") direction: String = "desc",
        @Query(value = "per_page") perPage: Int = 100,
        // @Query("affiliation") affiliation: String = "owner",
        @Query("t") t: String = "${System.currentTimeMillis()}"
    ): List<Repository>
}