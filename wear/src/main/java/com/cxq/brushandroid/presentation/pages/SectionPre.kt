package com.cxq.brushandroid.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.cxq.brushandroid.entity.Section
import com.cxq.brushandroid.presentation.theme.Typography
import com.cxq.brushandroid.presentation.theme.wearColor
import com.cxq.brushandroid.utils.SectionUtil
import kotlinx.coroutines.delay


@Composable
fun SectionPre(section: Section, navToSectionIng: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = wearColor.primary)
            .padding(top = 16.dp, bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            painter = painterResource(id = SectionUtil.getId(section)),
            contentScale = ContentScale.FillHeight,
            contentDescription = null
        )
        Text(
            text = SectionUtil.getName(section),
            style = Typography.title2.copy(fontWeight = FontWeight.SemiBold),
        )
    }

    LaunchedEffect(true) {
        delay(3000)
        navToSectionIng()
    }
}

@Preview(device = Devices.WEAR_OS_SQUARE, showSystemUi = true)
@Composable
fun SectionPreview() {
    SectionPre(Section.OLB){}
}
