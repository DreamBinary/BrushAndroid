package com.cxq.brushandroid.presentation.pages


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text
import com.cxq.brushandroid.R
import com.cxq.brushandroid.presentation.theme.Typography
import com.cxq.brushandroid.presentation.theme.wearColor


@Composable
fun RemedyIng() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 16.dp, bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            Image(
                modifier = Modifier
                    .padding(end = 3.dp)
                    .size(15.dp),
                painter = painterResource(id = R.drawable.tune_icon),
                contentDescription = null
            )
            Text(
                text = "把缺失的音律补起来！",
                style = Typography.caption1.copy(
                    fontWeight = FontWeight.Bold,
                    color = wearColor.onPrimary
                ),
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(modifier = Modifier
            .padding(end = 3.dp)
            .size(50.dp),painter = painterResource(id = R.drawable.remedy_ing0), contentDescription = null)
        Spacer(modifier = Modifier.weight(1f))
        Image(modifier = Modifier
            .padding(end = 3.dp)
            .height(20.dp),painter = painterResource(id = R.drawable.remedy_ing1), contentDescription = null)
        Spacer(modifier = Modifier.weight(0.5f))
        Text(
            text = "外右下边区",
            style = Typography.caption3.copy(
                fontWeight = FontWeight.Medium,
                color = wearColor.onPrimary
            ),
        )
    }
}

@Preview(device = Devices.WEAR_OS_SQUARE, showSystemUi = true)
@Composable
fun RemedyIngPreview() {
    RemedyIng()
}