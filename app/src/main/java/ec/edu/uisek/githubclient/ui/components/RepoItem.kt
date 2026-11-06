package ec.edu.uisek.githubclient.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun RepoItem (
    title: String,
    description: String,
    language: String,
    avatarImageUrl: String,
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            AsyncImage(
                model = avatarImageUrl,
                contentDescription = "Imagen de $title",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column() {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3
                    )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = language,
                    style = MaterialTheme.typography.bodySmall,
                    )
            }
        }
    }
}

@Preview
@Composable
fun RepoItemPreview(){
    RepoItem(
        title = "Repositorio de Nicolás",
        description = "Repositorio de Nicolás para Android",
        language = "Kotlin",
        avatarImageUrl = "https://avatars.githubusercontent.com/u/123456789?v=4"
    )
}

