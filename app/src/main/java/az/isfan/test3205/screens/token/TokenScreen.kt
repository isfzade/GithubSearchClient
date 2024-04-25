package az.isfan.test3205.screens.token

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import az.isfan.test3205.data.enums.RouteEnum
import az.isfan.test3205.general.Cavab
import az.isfan.test3205.screens.common.AlertScreen
import az.isfan.test3205.screens.common.LoadingScreen
import az.isfan.test3205.screens.token.components.TokenContent
import az.isfan.test3205.view_models.TokenViewModel

@Composable
fun TokenScreen(
    navController: NavHostController,
    tokenViewModel: TokenViewModel = hiltViewModel()
) {
    val token = tokenViewModel.token.collectAsStateWithLifecycle().value

    when (token) {
        is Cavab.Success -> {
            TokenContent(
                token = token.data,
                onSaveButtonClick = { newToken ->
                    tokenViewModel.saveToken(newToken)
                    navController.navigate(RouteEnum.SEARCH.name)
                },
                onSearchTopBarButtonClick = {
                    navController.navigate(RouteEnum.SEARCH.name)
                },
                onHistoryTopBarButtonClick = {
                    navController.navigate(RouteEnum.HISTORY.name)
                }
            )
        }
        is Cavab.Loading -> LoadingScreen()
        is Cavab.Error -> {
            AlertScreen(
                content = token.e,
                onDismiss = {
                    tokenViewModel.resetToken()
                }
            )
        }
        else -> Unit
    }

    GetTokenInEditToken(
        tokenViewModel = tokenViewModel
    )
}

@Composable
fun GetTokenInEditToken(
    tokenViewModel: TokenViewModel
) {
    LaunchedEffect(Unit) {
        tokenViewModel.getToken()
    }
}