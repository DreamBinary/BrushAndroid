package com.cxq.mobile.ui.component

/**
 * @author CXQ
 * @date 2023/7/27
 */
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.D
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.cxq.mobile.ui.theme.MyColor
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.sin

@Composable
fun NoteAnim() {
    var x by remember { mutableStateOf(0.dp) }

    var animX = animateDpAsState(
        targetValue = x,
        animationSpec = tween(durationMillis = 100, easing = LinearEasing)
    )





    BoxWithConstraints(
        Modifier.fillMaxSize().background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        val height = this.maxHeight
        val width = this.maxWidth

//        val y = with(LocalDensity.current) {
//            sin(animX.value.toPx()).toDp()
//        }
        val w = width / 2
        LaunchedEffect("NoteAnim") {
            while (true) {
                if (x > w) {
                    x = -w
                } else {
                    delay(100)
                    x += 1.dp
                }
            }
        }

//        val y = with(LocalDensity.current) {
//            sin(2 * PI / (width.toPx() / 2) * animX.value.toPx()).toFloat()
//                .toDp() * (height.toPx() / 6)
//        }
        Container(
            modifier = Modifier.size(30.dp)
                .offset(x = animX.value), bgColor = MyColor.primary
        ) {}


    }


}

@Preview
@Composable
fun NoteAnimPreview() {
    NoteAnim()
}