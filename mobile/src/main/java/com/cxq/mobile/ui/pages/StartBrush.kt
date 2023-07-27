package com.cxq.mobile.ui.pages


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cxq.mobile.R
import com.cxq.mobile.ui.component.LogoButton
import com.cxq.mobile.ui.theme.MyColor
import com.cxq.mobile.ui.theme.Typography


@Composable
fun StartBrush(onStart: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().background(MyColor.bgGradient),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BoxWithConstraints(contentAlignment = Alignment.Center) {
            val width = this.maxWidth
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(R.drawable.squiggles),
                contentDescription = null
            )

            Image(
                modifier = Modifier.width(width * 0.5f).fillMaxWidth(),
                painter = painterResource(R.drawable.tooth_shine),
                contentDescription = null
            )
        }

        Text(
            text = "开始刷牙！",
            style = Typography.displaySmall.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "让我们一起刷动音律吧！", style = Typography.titleLarge.copy(color = Color.Gray))
        Spacer(modifier = Modifier.weight(5f))
        LogoButton(onClick = onStart)
        Spacer(modifier = Modifier.weight(1f))
        Text(modifier = Modifier.padding(bottom = 50.dp), text = buildAnnotatedString {
            append("开启")
            withStyle(SpanStyle(color = Color.White)) {
                append("TuneBrush")
            }
            append("之旅")
        }, style = Typography.titleLarge)
        Text(text = "")
    }
}

@Preview
@Composable
fun BrushPreview() {
    StartBrush{}
}