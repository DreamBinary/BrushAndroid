package com.cxq.mobile.ui.pages


import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cxq.mobile.entity.Route

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main() {
    val navController = rememberNavController()
    val items: List<Screen> = listOf(
        Screen.Analysis,
        Screen.Brush,
        Screen.Mine
    )
    Scaffold(
        bottomBar = {
            BottomAppBar() {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->

//                    Image(painter = Icons.Default, contentDescription = null)

                    Spacer(modifier = Modifier.weight(1f))
                    Icon(modifier = Modifier.clickable{
                        navController.navigate(screen.route) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }, imageVector = Icons.Default.Add, contentDescription = null)
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    ) {
        Route(navController)
    }
}

sealed class Screen(val route: String) {
    object Analysis : Screen(Route.ANALYSIS)
    object Brush : Screen(Route.BRUSH)
    object Mine : Screen(Route.MINE)
}

@Preview
@Composable
fun MainPreview() {
    Main()
}