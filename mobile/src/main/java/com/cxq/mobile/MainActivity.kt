package com.cxq.mobile

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                    Greeting(bgmPlayer)
                }
            }
        }
    }
}

@Composable
fun Greeting(bgmPlayer: MediaPlayer, modifier: Modifier = Modifier) {
    Text(
        text = "Hello!",
        modifier = modifier.clickable {
            SpeakUtil.speakText("你好")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BrushAndroidTheme {
        Greeting(bgmPlayer = MediaPlayer.create(null, R.raw.bgm))
    }
}