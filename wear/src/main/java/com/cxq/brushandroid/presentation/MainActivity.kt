package com.cxq.brushandroid.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.cxq.brushandroid.entity.Section
import com.cxq.brushandroid.presentation.pages.SectionEd
import com.cxq.brushandroid.presentation.pages.SectionIng
import com.cxq.brushandroid.presentation.pages.SectionPre
import com.cxq.brushandroid.presentation.pages.Start
import com.cxq.brushandroid.presentation.theme.BrushAndroidTheme
import com.cxq.brushandroid.viewmodel.MyVM
import kotlin.text.Typography.section

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WearApp()
        }
    }
}

@Composable
fun WearApp(vm: MyVM = viewModel()) {
    BrushAndroidTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            verticalArrangement = Arrangement.Center
        ) {
            val navController = rememberSwipeDismissableNavController()
            SwipeDismissableNavHost(
                navController = navController,
                startDestination = "start"
            ) {
                composable("start") {
                    Start(vm.section){
                        navController.navigate("section_pre")
                    }
                }

                composable("section_pre") {
                    SectionPre(section = vm.section, navToSectionIng = {
                        navController.navigate("section_ing")
                    })
                }

                composable("section_ing") {
                    SectionIng(section = vm.section, navToSectionEd = {
                        navController.navigate("section_ed")
                    })
                }

                composable("section_ed") {
                    SectionEd(section = vm.section, navToSectionPre = { section ->
                        if (section != null) {
                            vm.section = section
                            navController.navigate("section_pre")
                        } else {
                            navController.navigate("start")
                        }
                    })
                }
            }
        }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    WearApp()
}