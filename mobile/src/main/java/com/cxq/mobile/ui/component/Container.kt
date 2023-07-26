package com.cxq.mobile.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Container(
    modifier: Modifier = Modifier,
    margin: Dp = 0.dp,
    roundedCorner: Dp = 15.dp,
    horizontal: Dp = 0.dp,
    vertical: Dp = 10.dp,
    bgColor: Color,
    bgAlpha: Float = 1f,
    content: @Composable ColumnScope.() -> Unit,
) {
    Surface(
        modifier = modifier
            .padding(margin)
            .fillMaxSize(),
        shape = RoundedCornerShape(roundedCorner),
        color = bgColor.copy(alpha = bgColor.alpha * bgAlpha),
        tonalElevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(vertical = vertical, horizontal = horizontal),
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            content()
        }
    }
}