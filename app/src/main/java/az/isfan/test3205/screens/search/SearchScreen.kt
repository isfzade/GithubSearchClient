package az.isfan.test3205.screens.search

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import az.isfan.test3205.data.enums.RouteEnum
import az.isfan.test3205.screens.search.components.SearchContent

@Composable
fun SearchScreen(
    navController: NavHostController
) {
    SearchContent(
        onSearchButtonClick = {

        },
        onHistoryTopBarButtonClick = {
            navController.navigate(RouteEnum.HISTORY.name)
        },
        onTokenTopBarButtonClick = {
            navController.navigate(RouteEnum.TOKEN.name)
        }
    )
}