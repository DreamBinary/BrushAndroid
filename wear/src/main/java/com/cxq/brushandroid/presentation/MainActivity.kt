package com.cxq.brushandroid.presentation

import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.navigation
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.cxq.brushandroid.R
import com.cxq.brushandroid.entity.Route
import com.cxq.brushandroid.presentation.pages.Finish
import com.cxq.brushandroid.presentation.pages.RemedyIng
import com.cxq.brushandroid.presentation.pages.RemedyPre
import com.cxq.brushandroid.presentation.pages.Score
import com.cxq.brushandroid.presentation.pages.SectionEd
import com.cxq.brushandroid.presentation.pages.SectionIng
import com.cxq.brushandroid.presentation.pages.SectionPre
import com.cxq.brushandroid.presentation.pages.Start
import com.cxq.brushandroid.presentation.theme.BrushAndroidTheme
import com.cxq.brushandroid.utils.SpeakUtil
import com.cxq.brushandroid.viewmodel.MyVM

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SpeakUtil.init(this)
        setContent {
            BrushAndroidTheme {
                WearApp()
            }
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
            val context = LocalContext.current
            lateinit var bgmPlayer: MediaPlayer
            SwipeDismissableNavHost(
                navController = navController, startDestination = Route.START
            ) {
//                composable(Route.HOME) {
//                    ScalingLazyColumn {
//                        item {
//                            Text(modifier = Modifier.clickable {
//                                vm.reset()
//                                navController.navigate(Route.BRUSH_ING)
//                                bgmPlayer = MediaPlayer.create(context, R.raw.bgm)
//                                bgmPlayer.start()
//                            }, text = "开始刷牙")
//                        }
//
//                        item {
//                            Text(modifier = Modifier.clickable {
//                                SpeakUtil.speakText("Hello World")
//                            }, text = "TEST")
//                        }
//                    }
//                }

                composable(Route.START) {
                    Start(vm.section, onStartPre = {
                        vm.reset()
                        bgmPlayer = MediaPlayer.create(context, R.raw.bgm)
                        bgmPlayer.start()
                    }, navToSection = {
                        navController.navigate(Route.BRUSH)
                    })
                }

                navigation(
                    startDestination = Route.SECTION_PRE,
                    route = Route.BRUSH,
                ) {
                    composable(Route.SECTION_PRE) {
                        SectionPre(section = vm.section, navToSectionIng = {
                            navController.popBackStack()
                            navController.navigate(Route.SECTION_ING)
                        })
                    }

                    composable(Route.SECTION_ING) {
                        SectionIng(section = vm.section, navToSectionEd = {
                            navController.popBackStack()
                            navController.navigate(Route.SECTION_ED)
                        })
                    }

                    composable(Route.SECTION_ED) {
                        SectionEd(section = vm.section, navToSectionPre = { section ->
                            if (section != null) {
                                vm.section = section
                                navController.popBackStack()
                                navController.navigate(Route.SECTION_PRE)
                            } else {
                                navController.popBackStack()
                                navController.navigate(Route.FINISH)
                            }
                        })
                    }

                    composable(Route.FINISH) {
                        Finish {
                            bgmPlayer.stop()
                            navController.popBackStack()
                            navController.navigate(Route.SCORE)
                        }
                    }

                    composable(Route.SCORE) {
                        Score {
                            navController.popBackStack()
                            navController.navigate(Route.REMEDY_PRE)
                        }
                    }

                    composable(Route.REMEDY_PRE) {
                        RemedyPre(toRemedy = {
                            navController.popBackStack()
                            navController.navigate(Route.REMEDY_ING)
                        }, noRemedy = {
                            navController.popBackStack()
                        })
                    }

                    composable(Route.REMEDY_ING) {
                        RemedyIng()
                    }
                }
            }
        }
    }
}


//@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
//@Composable
//fun DefaultPreview() {
//    WearApp()
//}