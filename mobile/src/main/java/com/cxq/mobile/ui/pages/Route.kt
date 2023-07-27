package com.cxq.mobile.ui.pages


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.cxq.mobile.entity.Route


@Composable
fun Route() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = Route.WELCOME
    ) {
        composable(Route.MAIN) {
            Main {
                navController.navigate(Route.BRUSH)
            }
        }
        composable(Route.WELCOME) {
            Welcome {
                navController.navigate(Route.ENTER)
            }
        }

        composable(Route.ENTER) {
            Enter {
                navController.navigate(Route.MAIN)
            }
        }

        composable(Route.ANALYSIS) {
            Analysis()
        }

        composable(Route.MINE) {
            Mine()
        }


        navigation(startDestination = Route.STARTBRUSH, route=Route.BRUSH) {
            composable(Route.STARTBRUSH) {
                StartBrush {
                    navController.navigate(Route.COUNTDOWN)
                }
            }

            composable(Route.COUNTDOWN) {
                CountDown {
                    navController.navigate(Route.BRUSHING)
                }
            }

            composable(Route.BRUSHING) {
                BrushIng()
            }
        }
    }
}