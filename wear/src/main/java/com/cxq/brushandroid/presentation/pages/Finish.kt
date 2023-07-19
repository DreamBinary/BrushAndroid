package com.cxq.brushandroid.presentation.pages


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
fun Finish(popUp: () -> Unit = {}) {
    Column(
        Modifier
            .fillMaxSize()
            .background(wearColor.primary)
            .padding(top = 16.dp, bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier.size(75.dp),
            painter = painterResource(id = R.drawable.finish),
            contentScale = ContentScale.FillHeight,
            contentDescription = null
        )
        Spacer(modifier = Modifier.weight(0.5f))
        Text(
            text = "您已完成今日份口腔清洁！",
            style = Typography.caption2.copy(
                fontWeight = FontWeight.Bold,
                color = wearColor.onPrimary
            ),
        )
        Text(
            text = "要好好保持哦！",
            style = Typography.caption3.copy(
                fontWeight = FontWeight.Medium,
                color = Color.Gray
            ),
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.clickable { popUp() },
            text = "OK",
            style = Typography.caption1.copy(
                fontWeight = FontWeight.Medium,
                color = wearColor.onPrimary,
            ),
            textDecoration = TextDecoration.Underline
        )
    }
}

@Preview(device = Devices.WEAR_OS_SQUARE, showSystemUi = true)
@Composable
fun FinishPreview() {
    Finish()
}