package com.cxq.mobile.ui.pages

/**
 * @author CXQ
 * @date 2023/7/27
 */
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cxq.mobile.R
import com.cxq.mobile.ui.theme.MyColor
import com.cxq.mobile.ui.theme.Typography
import kotlinx.coroutines.delay

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CountDown(navToNext: () -> Unit) {
    var time by remember { mutableIntStateOf(3) }
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val height = this.maxHeight
        Image(
            painter = painterResource(R.drawable.count_down_bg),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(Modifier.height(height / 2))
            Text(
                text = "准备好了吗？",
                style = Typography.displaySmall.copy(fontWeight = FontWeight.Bold)
            )

            Text(
                text = "我们马上要开始啦！",
                style = Typography.displaySmall.copy(fontWeight = FontWeight.Bold)
            )
            Row(Modifier.wrapContentHeight()) {
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    modifier = Modifier.weight(2f),
                    painter = painterResource(R.drawable.line),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.weight(0.2f))
            }
            Spacer(Modifier.weight(1f))
            Text(
                text = "倒计时",
                style = Typography.displaySmall.copy(fontWeight = FontWeight.Bold)
            )

            AnimatedContent(
                targetState = time,
                transitionSpec = {
                    (slideInVertically() + fadeIn() + scaleIn(initialScale = 2f)).togetherWith(
                        slideOutVertically() + fadeOut() + scaleOut(targetScale = 1f)
                    )
                }
            ) { targetCount ->
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = "$targetCount",
                    style = Typography.displayLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = MyColor.primary
                    )
                )
            }
            Spacer(Modifier.weight(4f))
        }
    }

    LaunchedEffect(0) {
        while (time > 0) {
            delay(1000)
            time -= 1
        }
        navToNext()
    }
}