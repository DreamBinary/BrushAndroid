package com.cxq.mobile.ui.pages


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cxq.mobile.entity.Route


@Composable
fun Route(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = Route.ANALYSIS
    ) {
        composable(Route.ENTER) {
            Enter()
        }

        composable(Route.ANALYSIS) {
            Analysis()
        }

        composable(Route.BRUSH) {
            Brush()
        }

        composable(Route.MINE) {
            Mine()
        }

    }
}