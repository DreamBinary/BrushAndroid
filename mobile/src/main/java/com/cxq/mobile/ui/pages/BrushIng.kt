package com.cxq.mobile.ui.pages

/**
 * @author CXQ
 * @date 2023/7/27
 */
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cxq.mobile.R
import com.cxq.mobile.ui.theme.MyColor
import com.cxq.mobile.ui.theme.Typography

@Composable
fun BrushIng() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.brushing_bg_2),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.weight(1f))
            Row(Modifier.padding(vertical = 5.dp), verticalAlignment = Alignment.CenterVertically) {
                Spacer(Modifier.width(30.dp))
                Image(
                    modifier = Modifier
                        .shadow(10.dp, shape = CircleShape)
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(MyColor.primary),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null
                )
                Spacer(Modifier.width(10.dp))
                Text(
                    "TuneBrush",
                    style = Typography.headlineMedium.copy(color = MyColor.primary)
                )
                Spacer(Modifier.weight(1f))
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("尽情享受在 TuneBrush", style = Typography.headlineLarge)
                Row(Modifier.wrapContentHeight()) {
                    Spacer(modifier = Modifier.weight(2f))
                    Image(
                        modifier = Modifier.weight(2f),
                        painter = painterResource(R.drawable.line),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.weight(0.2f))
                }
                Text("的交响乐盛典", style = Typography.headlineLarge)
            }


//            Box(Modifier.wrapContentHeight()) {
//                Image(
//                    modifier = Modifier.padding(
//                        start = 25.dp,
//                        end = 40.dp,
//                        top = 60.dp,
//                        bottom = 20.dp,
//                    ),
//                    painter = painterResource(R.drawable.radio),
//                    contentDescription = null
//                )
//            }
            Spacer(Modifier.weight(5f))
            Spacer(Modifier.weight(2f))
        }
    }
}

@Preview
@Composable
fun BrushIngPreview() {
    BrushIng()
}