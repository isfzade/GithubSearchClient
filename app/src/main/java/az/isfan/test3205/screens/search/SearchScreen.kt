package az.isfan.test3205.screens.search

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import az.isfan.test3205.data.enums.RouteEnum
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
    val repos = searchViewModel.repos.collectAsStateWithLifecycle().value

    SearchContent(
        repos = repos,
        onSearchButtonClick = { userName ->
            searchViewModel.search(
                page = 1,
                userName = userName,
            )
        },
        onHistoryTopBarButtonClick = {
            navController.navigate(RouteEnum.HISTORY.name)
        },
        onTokenTopBarButtonClick = {
            navController.navigate(RouteEnum.TOKEN.name)
        },
        onOpenLinkClick = { repo ->

        },
        onDownloadButtonClick = { repo ->

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