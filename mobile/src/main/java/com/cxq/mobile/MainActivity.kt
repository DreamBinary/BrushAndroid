package com.cxq.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.cxq.mobile.ui.component.NoteAnim
import com.cxq.mobile.ui.pages.BrushIng
import com.cxq.mobile.ui.pages.CountDown
import com.cxq.mobile.ui.pages.Main
import com.cxq.mobile.ui.pages.Route
import com.cxq.mobile.ui.pages.StartBrush
import com.cxq.mobile.ui.pages.Welcome
import com.cxq.mobile.ui.theme.BrushAndroidTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
            }
        })
        SpeakUtil.init(this)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            BrushAndroidTheme {
                TransparentSystemBars()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Route()
//                    NoteAnim()
                }
            }
        }
    }
}

@Composable
fun TransparentSystemBars() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons,
            isNavigationBarContrastEnforced = false,
        )
    }
}