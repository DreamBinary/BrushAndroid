package com.cxq.mobile.ui.pages


import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.cxq.mobile.R
import com.cxq.mobile.ui.component.Container
import com.cxq.mobile.ui.theme.MyColor
import com.cxq.mobile.ui.theme.Typography


@Composable
fun Analysis() {
    val selectedMonth = remember {
        mutableStateOf(5)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                androidx.compose.ui.graphics.Brush.verticalGradient(
                    listOf(
                        MyColor.primary, Color.White
                    )
                )
            )
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(top = 20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier.height(60.dp),
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = null
            )
            Column {
                Text(
                    text = "Hi, Worsh!",
                    style = Typography.titleLarge
                )
                Text(
                    text = "Are you ready for your new journey?",
                    style = Typography.bodyMedium.copy(
                        color = Color.Gray
                    )
                )
            }
            Spacer(modifier = Modifier.weight(1f))
        }


        StartContainer()

        Text(
            modifier = Modifier.padding(start = 25.dp, top = 20.dp, bottom = 10.dp),
            text = "Your Analysis",
            style = Typography.titleLarge
        )

        MonthRow(selectedMonth = selectedMonth.value) {
            selectedMonth.value = it + 1
        }

        Row(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 14.dp, vertical = 5.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Container(
                    Modifier.weight(2f),
                    margin = 6.dp,
                    bgColor = Color(0xff003FE2).copy(alpha = 0.4f),
                    bgAlpha = 0.5f
                ) {
                    Text(
                        text = "历史最高分",
                        style = Typography.headlineSmall.copy(
                            color = Color.White
                        )
                    )
                    Text(
                        text = "99",
                        style = Typography.displaySmall.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "月度最高 Top", style = Typography.titleMedium
                    )
                }

                Container(
                    Modifier.weight(2.5f),
                    margin = 6.dp,
                    bgColor = Color(0xffFFE193).copy(alpha = 0.72f),
                    bgAlpha = 0.8f
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        modifier = Modifier.fillMaxWidth(),
                        painter = painterResource(id = R.drawable.month_score),
                        contentDescription = null
                    )
                    Text(text = "月度评分 Monthly", style = Typography.titleMedium)

                }
            }

            Column(modifier = Modifier.weight(1f)) {
                Container(
                    Modifier.weight(1f),
                    margin = 6.dp,
                    bgColor = Color(0xff00C4DF).copy(alpha = 0.4f),
                    bgAlpha = 0.5f
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier.weight(1f),
                            painter = painterResource(id = R.drawable.brush_in),
                            contentDescription = null
                        )
                        LinearProgressIndicator(
                            modifier = Modifier
                                .weight(3f)
                                .height(5.dp)
                                .padding(horizontal = 2.dp),
                            progress = 0.6f,
                            color = Color.White,
                            trackColor = Color.White.copy(alpha = 0.5f)
                        )
                        Image(
                            modifier = Modifier.weight(1f),
                            painter = painterResource(id = R.drawable.brush_out),
                            contentDescription = null
                        )
                    }
                    Text(text = "平均力度 Average", style = Typography.titleMedium)
                }

                BoxWithConstraints(Modifier.weight(3f), contentAlignment = Alignment.Center) {
                    val y = this.maxHeight / 2
                    val x = this.maxWidth / 2
                    Container(
                        margin = 6.dp,
                        bgColor = Color(0xffA684C8).copy(alpha = 0.5f)
                    ) {
                        Spacer(modifier = Modifier.weight(1f))

                        Text(text = "热词 Conclusion", style = Typography.titleMedium)
                    }

                    HotWord(
                        Modifier.offset(x = x * 0.6f, y = -y * 0.7f),
                        word = "刷轻啦",
                        horizontal = 15.dp,
                        vertical = 10.dp
                    )

                    HotWord(
                        Modifier.offset(x = -x * 0.3f, y = -y * 0.4f),
                        word = "外左上",
                        horizontal = 15.dp,
                        vertical = 10.dp
                    )

                    HotWord(
                        Modifier.offset(x = x * 0.2f),
                        word = "内右上",
                        horizontal = 15.dp,
                        vertical = 10.dp
                    )

                    HotWord(
                        Modifier.offset(x = -x * 0.5f, y = y * 0.4f),
                        word = "再用点劲",
                        horizontal = 15.dp,
                        vertical = 10.dp
                    )

                    HotWord(
                        Modifier.offset(x = x * 0.5f, y = y * 0.6f),
                        word = "外左上"
                    )
                }
            }
        }
    }
}

@Composable
fun HotWord(
    modifier: Modifier = Modifier, horizontal: Dp = 10.dp,
    vertical: Dp = 6.dp, word: String
) {
    Text(
        modifier = modifier
            .shadow(elevation = 8.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(Color.White)
            .padding(horizontal = horizontal, vertical = vertical),
        text = word,
        style = Typography.bodyLarge.copy(
            color = Color(0xffA684C8).copy(alpha = 0.5f),
            fontWeight = FontWeight.Bold
        )
    )

}

@Composable
fun StartContainer() {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xffE1F5B3))
            .padding(horizontal = 20.dp, vertical = 15.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "New TuneBrush Journey",
                style = Typography.titleLarge
            )
            Text(
                text = "预计进行 12min      现在就开始！",
                style = Typography.bodyMedium.copy(color = Color.Gray)
            )
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "Get Started!",
                textDecoration = TextDecoration.Underline,
                style = Typography.titleLarge
            )
        }
        Image(
            modifier = Modifier.weight(1f),
            painter = painterResource(id = R.drawable.analysis_bg),
            contentDescription = null
        )

    }
}


@Composable
fun MonthRow(selectedMonth: Int, onSelect: (Int) -> Unit = {}) {

    val months =
        listOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Noc", "Dec")

    val monthsCn = listOf(
        "一月",
        "二月",
        "三月",
        "四月",
        "五月",
        "六月",
        "七月",
        "八月",
        "九月",
        "十月",
        "十一月",
        "十二月"
    )

    val selectedTabIndex = selectedMonth - 1;

    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = Color.Transparent,
        divider = {},
        indicator = {},
        edgePadding = 10.dp
    ) {
        months.indices.forEach { index ->
            Column(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        animateColorAsState(
                            targetValue = if (selectedTabIndex == index) Color(0xff365869) else Color.White.copy(
                                alpha = 0.43f
                            )
                        ).value
                    )
                    .width(40.dp)
                    .height(90.dp)
                    .clickable {
                        onSelect(index)
                    }, horizontalAlignment = CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(2f))
                Text(
                    text = monthsCn[index], style = Typography.bodyMedium.copy(
                        color = animateColorAsState(targetValue = if (selectedTabIndex == index) Color.White else Color.Gray).value,
                    )
                )
                Spacer(modifier = Modifier.weight(3f))
                Text(
                    text = months[index],
                    style = Typography.titleLarge.copy(
                        color = animateColorAsState(
                            targetValue = if (selectedTabIndex == index) Color.White else Color(
                                0xff365869
                            )
                        ).value,
                    )
                )
                Spacer(modifier = Modifier.weight(3f))
            }

        }
    }
}

//@Preview
//@Composable
//fun MonthRowPreview() {
//    MonthRow(5)
//}

@Preview
@Composable
fun AnalysisPreview() {
    Analysis()
}