package com.cxq.brushandroid.presentation.pages


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun Tip() {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = wearColor.primary)
            .padding(horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(2f))
        Box {
            Column {
                Spacer(modifier = Modifier.height(25.dp))
                Row(
                    modifier = Modifier
                        .background(
                            Color(0xFFECECEC).copy(alpha = 0.5F),
                            shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                        )
                        .padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(id = R.drawable.vibrate),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "TUNEBRUSH",
                        style = Typography.body2.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = wearColor.onPrimary
                        ),
                    )
                }
                Column(
                    modifier = Modifier
                        .background(
                            Color(0xffECECEC),
                            shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)
                        )
                        .padding(5.dp),
                ) {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "力度太轻啦，可以再用力一些些！",
                        style = Typography.caption2.copy(
                            fontWeight = FontWeight.Bold,
                            color = wearColor.onPrimary
                        ),
                    )

                    Image(
                        modifier = Modifier.padding(bottom = 5.dp, start = 10.dp, end = 10.dp),
                        painter = painterResource(id = R.drawable.tip2),
                        contentDescription = null
                    )
                }
            }
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 5.dp),
                painter = painterResource(id = R.drawable.tip),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier
                .background(
                    color = Color(0xff263238).copy(alpha = 0.9f),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(horizontal = 60.dp, vertical = 5.dp),
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(

                text = "忽略",
                style = Typography.body2.copy(
                    fontWeight = FontWeight.Bold,
                    color = wearColor.primary
                ),
            )
            Spacer(modifier = Modifier.width(5.dp))
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview(device = Devices.WEAR_OS_SQUARE, showSystemUi = true)
@Composable
fun TipPreview() {
    Tip()
}