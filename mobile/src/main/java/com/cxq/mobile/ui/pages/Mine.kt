package com.cxq.mobile.ui.pages


import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.cxq.mobile.R
import com.cxq.mobile.ui.component.Container
import com.cxq.mobile.ui.theme.MyColor
import com.cxq.mobile.ui.theme.Typography
import kotlin.math.sqrt


@Composable
fun Mine() {
    BoxWithConstraints(contentAlignment = Alignment.Center) {
        val height = maxHeight
        val width = maxWidth
        val scrollState = rememberScrollState()
        val scrollDp = animateDpAsState(targetValue = with(LocalDensity.current) {
            scrollState.value.toDp()
        })
        Column(Modifier.background(MyColor.primary)) {
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier
                    .height(height * 0.75f + scrollDp.value)
                    .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                    .background(Color.White)
                    .fillMaxSize()
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(width * 0.6f * sqrt(6f) / 4))
                Text(
                    text = "Conan Worsh",
                    style = Typography.displayMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = "I want BRIGHT smile",
                    style = Typography.titleLarge.copy(color = Color.Gray)
                )
                Spacer(modifier = Modifier.height(20.dp))
                TwoWordText(first = "136", last = "天")

                Text(
                    text = "加入 TuneBrush",
                    style = Typography.titleLarge.copy(
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                )


                val h =
                    height * 0.75f - width * 0.6f * sqrt(6f) / 4 - 20.dp - with(LocalDensity.current) {
                        Typography.displayMedium.lineHeight.toDp()
                    } * 2 - with(LocalDensity.current) {
                        Typography.titleLarge.fontSize.toDp()
                    } * 2 - 40.dp

                Row(
                    Modifier
                        .height(h)
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                ) {
                    Container(Modifier.weight(1f), bgColor = Color(0xffA9C1FD), vertical = 8.dp) {
                        Box(contentAlignment = Alignment.BottomStart) {
                            Image(
                                modifier = Modifier.padding(5.dp),
                                painter = painterResource(id = R.drawable.cavity),
                                contentDescription = null
                            )
                            Column(
                                modifier = Modifier.padding(start = 10.dp),
                                horizontalAlignment = Alignment.Start
                            ) {
                                TwoWordText(first = "93", last = "分")
                                Text(
                                    text = "查看刷牙情况",
                                    style = Typography.titleLarge.copy(
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))

                    Container(Modifier.weight(1f), bgColor = Color(0xffA9FDC0), vertical = 8.dp) {
                        Box(contentAlignment = Alignment.BottomStart) {
                            Image(
                                modifier = Modifier.padding(5.dp),
                                painter = painterResource(id = R.drawable.tooth_xray_spot),
                                contentDescription = null
                            )
                            Column(
                                modifier = Modifier.padding(start = 10.dp),
                                horizontalAlignment = Alignment.Start
                            ) {
                                TwoWordText(first = "16", last = "天")
                                Text(
                                    text = "牙刷更换情况",
                                    style = Typography.titleLarge.copy(
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }
                        }
                    }
                }

                ElevatedButton(
                    modifier = Modifier
                        .padding(horizontal = 40.dp, vertical = 20.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xffe9e9e9)),
                    onClick = { /*TODO*/ }) {
                    Text(
                        text = "退出当前帐号",
                        style = Typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                    )
                }
            }
        }

        Avatar(
            Modifier.offset(y = -height / 4 - scrollDp.value),
            bgSize = width * (0.6f - 0.15f * scrollState.value / scrollState.maxValue),
            avatarSize = width * 0.45f,
            degrees = scrollState.value * 30f / scrollState.maxValue - 15f
        )
    }
}

@Composable
fun TwoWordText(first: String, last: String) {
    Row(
        Modifier.wrapContentHeight(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = first,
            style = Typography.displayMedium.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            modifier = Modifier.padding(bottom = 8.dp),
            text = last,
            style = Typography.titleLarge.copy(color = Color.Gray)
        )
    }
}


@Composable
fun Avatar(modifier: Modifier = Modifier, bgSize: Dp, avatarSize: Dp, degrees: Float = -15f) {
//    val degrees = -15f
//    val animDegrees = animateFloatAsState(targetValue = degrees)
    val roundedCorner = ((bgSize * 0.5f + 15.dp) / 2 + (bgSize * 0.5f - 15.dp) / 30f * degrees)
    Box(modifier, contentAlignment = Alignment.Center) {
        Container(
            Modifier
                .size(bgSize)
                .rotate(degrees)
                .shadow(10.dp, shape = RoundedCornerShape(roundedCorner)),
            roundedCorner = roundedCorner,
            bgColor = Color(0xffA9C1FD)
        ) {
            Spacer(modifier = Modifier.weight(1f))
        }
        Surface(
            Modifier.size(avatarSize),
            shape = CircleShape,
            color = MyColor.lightPrimary,
            shadowElevation = 1.dp
        ) {
            Image(
                modifier = Modifier.size(avatarSize * 0.8f),
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = null
            )
        }
    }
}


@Preview
@Composable
fun MinePreview() {
    Mine()
}