package az.isfan.test3205.screens.history.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import az.isfan.test3205.data.models.DownloadData

@Composable
fun ItemInHistory(
    download: DownloadData
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(
                space = 5.dp
            )
        ) {
            Text(
                text = download.owner,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = download.repoName,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 20.sp,
            )
        }
    }
}