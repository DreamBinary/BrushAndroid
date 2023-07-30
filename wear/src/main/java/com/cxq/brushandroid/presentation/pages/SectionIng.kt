package com.cxq.brushandroid.presentation.pages


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
fun SectionIng(section: Section, navToSectionEd: () -> Unit = {}) {
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
            painter = painterResource(id = R.drawable.sec_ing),
            contentScale = ContentScale.FillHeight,
            contentDescription = null
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier.padding(end = 3.dp).size(15.dp),
                painter = painterResource(id = R.drawable.tune_icon),
                contentDescription = null
            )
            Text(
                text = SectionUtil.getName(section),
                style = Typography.body2.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = wearColor.primary
                ),
            )
        }
        Spacer(modifier = Modifier.weight(1.5f))
        Text(
            text = "Next: ${SectionUtil.getName(SectionUtil.getNext(section))}",
            style = Typography.caption3.copy(
                fontWeight = FontWeight.Medium,
                color = wearColor.onPrimary
            ),
        )
    }

    LaunchedEffect(true) {
        delay(30000)
        navToSectionEd()
    }

}

@Preview(device = Devices.WEAR_OS_SQUARE, showSystemUi = true)
@Composable
fun SectionIngPreview() {
    SectionIng(Section.OLB)
}