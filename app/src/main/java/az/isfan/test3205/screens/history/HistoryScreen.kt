package az.isfan.test3205.screens.history

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import az.isfan.test3205.general.Cavab
import az.isfan.test3205.screens.common.AlertScreen
import az.isfan.test3205.screens.common.LoadingScreen
import az.isfan.test3205.screens.history.components.HistoryContent
import az.isfan.test3205.view_models.HistoryViewModel

@Composable
fun HistoryScreen(
    navController: NavHostController,
    historyViewModel: HistoryViewModel = hiltViewModel()
) {
    val downloads = historyViewModel.downloads.collectAsStateWithLifecycle().value

    when (downloads) {
        is Cavab.Success, Cavab.StandBy -> {
            HistoryContent(
                downloads = downloads,
                onBackTopBarButtonClick = {
                    navController.navigateUp()
                }
            )
        }
        is Cavab.Loading -> LoadingScreen()
        is Cavab.Error -> {
            AlertScreen(
                content = downloads.e,
                onDismiss = {
                    historyViewModel.resetDownloads()
                }
            )
        }
    }
}