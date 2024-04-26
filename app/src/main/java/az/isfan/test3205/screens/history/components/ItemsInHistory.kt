package az.isfan.test3205.screens.history.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import az.isfan.test3205.R
import az.isfan.test3205.data.models.DownloadData
import az.isfan.test3205.general.Cavab

@Composable
fun ItemsInHistory(
    downloads: Cavab<List<DownloadData>>,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(top=5.dp, start = 10.dp, end = 10.dp),
    ) {
        if (downloads is Cavab.Success && downloads.data.isNotEmpty()) {
            items(count = downloads.data.size) { index ->
                ItemInHistory(
                    download = downloads.data[index],
                )
            }
        }
        else {
            item {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = stringResource(R.string.nothing_to_show),
                    textAlign = TextAlign.Center,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 20.sp
                )
            }
        }
    }
}