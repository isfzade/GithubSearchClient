package az.isfan.test3205.screens.search.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import az.isfan.test3205.R
import az.isfan.test3205.data.models.RepoData
import az.isfan.test3205.general.Cavab
import az.isfan.test3205.screens.common.TopBarScreen

@Composable
fun SearchContent(
    repos: Cavab<List<RepoData>>,
    onSearchButtonClick: (userName: String?) -> Unit,
    onHistoryTopBarButtonClick: () -> Unit,
    onTokenTopBarButtonClick: () -> Unit,
    onDownloadButtonClick: (repo: RepoData) -> Unit,
) {
    Scaffold(
        topBar = {
            TopBarScreen(
                title = stringResource(R.string.app_name),
                onHistoryButtonClick = onHistoryTopBarButtonClick,
                onTokenButtonClick = onTokenTopBarButtonClick,
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
        ) {
            ItemsInSearch(
                repos = repos,
                onSearchButtonClick = onSearchButtonClick,
                onDownloadButtonClick = onDownloadButtonClick
            )
        }
    }
}