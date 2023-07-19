package com.cxq.brushandroid.presentation.pages


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text
import com.cxq.brushandroid.R
import com.cxq.brushandroid.entity.Section
import com.cxq.brushandroid.presentation.theme.Typography
import com.cxq.brushandroid.presentation.theme.wearColor
import com.cxq.brushandroid.utils.SectionUtil
import kotlinx.coroutines.delay


@Composable
fun SectionEd(section: Section, navToSectionPre: (section: Section?) -> Unit = {}) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 16.dp, bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(2f))
        Image(
            modifier = Modifier.size(75.dp),
            painter = painterResource(id = R.drawable.sec_ed),
            contentScale = ContentScale.FillHeight,
            contentDescription = null
        )
        Spacer(modifier = Modifier.weight(0.5f))
        Text(
            text = "Congratulations!",
            style = Typography.caption3.copy(
                fontWeight = FontWeight.Medium,
                color = wearColor.onPrimary
            ),
        )
        Spacer(modifier = Modifier.weight(0.5f))
        Text(
            text = "即将进入下一片区",
            style = Typography.body2.copy(
                fontWeight = FontWeight.SemiBold,
                color = wearColor.primary
            ),
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Next: ${SectionUtil.getName(SectionUtil.getNext(section))}",
            style = Typography.caption3.copy(
                fontWeight = FontWeight.Medium,
                color = wearColor.onPrimary
            ),
        )
    }

    LaunchedEffect(true) {
        delay(100)
        navToSectionPre(SectionUtil.getNext(section))
    }
}

@Preview(device = Devices.WEAR_OS_SQUARE, showSystemUi = true)
@Composable
fun SectionEdPreview() {
    SectionEd(Section.OLB)
}