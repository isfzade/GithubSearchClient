package az.isfan.test3205.screens.history.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import az.isfan.test3205.R
import az.isfan.test3205.data.models.DownloadData
import az.isfan.test3205.general.Cavab
import az.isfan.test3205.screens.common.TopBarScreen

@Composable
fun HistoryContent(
    downloads: Cavab<List<DownloadData>>,
    onBackTopBarButtonClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopBarScreen(
                title = stringResource(R.string.download_history),
                onBackButtonClick = onBackTopBarButtonClick,
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
        ) {
            ItemsInHistory(
                downloads = downloads,
            )
        }
    }
}