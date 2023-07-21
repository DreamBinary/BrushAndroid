package com.cxq.brushandroid.presentation.pages


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun RemedyPre(toRemedy: () -> Unit, noRemedy: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .background(wearColor.primary)
            .padding(top = 16.dp, bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .height(70.dp)
                .fillMaxHeight()
                .padding(bottom = 5.dp),
            painter = painterResource(id = R.drawable.remedy_pre),
            contentDescription = null
        )

        Text(
            text = "是否进入弥补环节",
            style = Typography.caption1.copy(

                fontWeight = FontWeight.Bold,
                color = wearColor.onPrimary
            ),
        )
        Text(
            text = "刷一刷更健康哦！",
            style = Typography.caption3.copy(
                fontWeight = FontWeight.Medium,
                color = Color.Gray
            ),
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier
                .background(
                    color = Color(0xffEFF1FF).copy(alpha = 0.6f),
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(horizontal = 5.dp, vertical = 3.dp)
                .clickable {
                    toRemedy()
                },
            text = "开始弥补",
            style = Typography.caption3.copy(
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            ),
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            modifier = Modifier.clickable {
                noRemedy()
            },
            text = "就这样吧",
            style = Typography.caption3.copy(
                fontSize = Typography.caption3.fontSize * 0.8,
                fontWeight = FontWeight.Normal,
                color = wearColor.onPrimary
            ),
            textDecoration = TextDecoration.Underline,
        )
    }
}

@Preview(device = Devices.WEAR_OS_SQUARE, showSystemUi = true)
@Composable
fun RemedyPrePreview() {
    RemedyPre(toRemedy = { }) {


    }
}