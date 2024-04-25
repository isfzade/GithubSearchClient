package az.isfan.test3205.screens.search.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.style.TextOverflow
import az.isfan.test3205.data.models.RepoData
import coil.compose.AsyncImage

@Composable
fun ItemInRepo(
    repo: RepoData,
    onOpenLinkClick: (repo: RepoData) -> Unit,
    onDownloadButtonClick: (repo: RepoData) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    ) {
                        if (repo.owner.avatar != null) {
                            AsyncImage(
                                model = repo.owner.avatar,
                                contentDescription = "avatar of owner",
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .weight(3f)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = repo.owner.name,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                Text(
                    text = repo.name,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                if (repo.description != null) {
                    Text(
                        text = repo.description,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
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
                        onOpenLinkClick(repo)
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