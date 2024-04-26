package az.isfan.test3205.screens.search

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import az.isfan.test3205.data.enums.RouteEnum
import az.isfan.test3205.download.Downloader
import az.isfan.test3205.general.Cavab
import az.isfan.test3205.screens.common.AlertScreen
import az.isfan.test3205.screens.common.LoadingScreen
import az.isfan.test3205.screens.search.components.SearchContent
import az.isfan.test3205.view_models.SearchViewModel

@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val repos = searchViewModel.repos.collectAsStateWithLifecycle().value
    val token = searchViewModel.token.collectAsStateWithLifecycle().value

    SearchContent(
        repos = repos,
        onSearchButtonClick = { userName ->
            searchViewModel.search(userName)
        },
        onHistoryTopBarButtonClick = {
            navController.navigate(RouteEnum.HISTORY.name)
        },
        onTokenTopBarButtonClick = {
            navController.navigate(RouteEnum.TOKEN.name)
        },
        onDownloadButtonClick = { repo ->
            if (token != null) {
                try {
                    val downloader = Downloader(context)
                    downloader.downloadRepo(
                        title = "${repo.owner.name}-${repo.name}",
                        url = repo.downloadUrl,
                        token = token
                    )
                    searchViewModel.saveDownload(repo)
                }
                catch (e: Exception) {
                    Log.e("isf_", "Download: e=$e")
                }
            }
        }
    )

    when (repos) {
        is Cavab.Loading -> LoadingScreen()
        is Cavab.Error -> {
            AlertScreen(
                content = repos.e,
                onDismiss = {
                    searchViewModel.resetRepos()
                }
            )
        }
        else -> Unit
    }
}