package az.isfan.test3205.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import az.isfan.test3205.data.enums.RouteEnum
import az.isfan.test3205.screens.history.HistoryScreen
import az.isfan.test3205.screens.search.SearchScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController()
) {
    val TAG = "isf_NavGraph"

    NavHost(
        navController = navController,
        startDestination = RouteEnum.SEARCH.name
    ) {
        composable(route = RouteEnum.SEARCH.name) {
            Log.i(TAG, "NavGraph: route=${RouteEnum.SEARCH}")
            SearchScreen(
                navController = navController,
            )
        }

        composable(route = RouteEnum.HISTORY.name) {
            Log.i(TAG, "NavGraph: route=${RouteEnum.HISTORY}")
            HistoryScreen(
                navController = navController,
            )
        }
    }
}