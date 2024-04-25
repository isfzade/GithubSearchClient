package az.isfan.test3205.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import az.isfan.test3205.data.enums.RouteEnum
import az.isfan.test3205.screens.search.SearchScreen
import az.isfan.test3205.screens.token.TokenScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController()
) {
    val TAG = "isf_NavGraph"

    NavHost(
        navController = navController,
        startDestination = RouteEnum.TOKEN.name
    ) {
        composable(route = RouteEnum.SEARCH.name) {
            Log.i(TAG, "NavGraph: route=${RouteEnum.SEARCH}")
            SearchScreen(
                navController = navController,
            )
        }

        composable(route = RouteEnum.TOKEN.name) {
            Log.i(TAG, "NavGraph: route=${RouteEnum.TOKEN}")
            TokenScreen(
                navController = navController,
            )
        }

        composable(route = RouteEnum.HISTORY.name) {
            Log.i(TAG, "NavGraph: route=${RouteEnum.HISTORY}")

        }
    }
}