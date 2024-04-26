package az.isfan.test3205.screens.search.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AdsClick
import androidx.compose.material.icons.filled.Download
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import az.isfan.test3205.data.models.RepoData
import coil.compose.AsyncImage

@Composable
fun ItemInSearch(
    repo: RepoData,
    onDownloadButtonClick: (repo: RepoData) -> Unit,
) {
    val uriHandler = LocalUriHandler.current

    Card(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(
                    space = 5.dp
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 5.dp
                    )
                ) {
                    if (repo.owner.avatar != null) {
                        AsyncImage(
                            modifier = Modifier
                                .size(30.dp, 30.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop,
                            model = repo.owner.avatar,
                            contentDescription = "avatar of owner",
                        )
                    }

                    Text(
                        text = repo.owner.name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Text(
                    text = repo.name,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 20.sp,
                )

                if (repo.description != null) {
                    Text(
                        text = repo.description,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 17.sp,
                        fontStyle = FontStyle.Italic
                    )
                }
            }


            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = {
                        try {
                            uriHandler.openUri(repo.url)
                        } catch (e: Exception) {
                            Log.e("isf_", "Github token link: error = $e")
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.AdsClick,
                        contentDescription = "open repo in browser button"
                    )
                }
            }

            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = {
                        onDownloadButtonClick(repo)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Download,
                        contentDescription = "download repo button"
                    )
                }
            }
        }
    }
}