package com.cxq.mobile

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.cxq.mobile.ui.pages.Enter
import com.cxq.mobile.ui.theme.BrushAndroidTheme

class MainActivity : ComponentActivity() {

    private val bgmPlayer by lazy {
        MediaPlayer.create(this, R.raw.bgm)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
            }
        })
        SpeakUtil.init(this)
        setContent {
            BrushAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Enter()
                }
            }
        }
    }
}