package com.cxq.brushandroid.presentation.pages


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text
import com.cxq.brushandroid.R
import com.cxq.brushandroid.presentation.theme.Typography
import com.cxq.brushandroid.presentation.theme.wearColor


@Composable
fun Score() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 16.dp, bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(2f))
        Box(contentAlignment = Alignment.BottomCenter) {
            Image(
                modifier = Modifier.size(75.dp),
                painter = painterResource(id = R.drawable.score),
                contentDescription = null,
            )
            Text(
                modifier = Modifier.padding(bottom = 5.dp),
                text = "90分",
                style = Typography.caption3.copy(
                    fontWeight = FontWeight.Medium,
                    color = wearColor.onPrimary
                ),
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "你还可以做得更好！", style = Typography.body2.copy(
                fontWeight = FontWeight.SemiBold,
                color = wearColor.primary
            )
        )
        Spacer(modifier = Modifier.weight(2f))

        Text(
            text = "查看评分详情",
            style = Typography.caption3.copy(
                fontWeight = FontWeight.SemiBold,
                color = wearColor.onPrimary
            ),
            textDecoration = TextDecoration.Underline,
        )
    }
}

@Preview(device = Devices.WEAR_OS_SQUARE, showSystemUi = true)
@Composable
fun ScorePreview() {
    Score()
}