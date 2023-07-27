package com.cxq.mobile.ui.theme

import androidx.compose.ui.graphics.Color

object MyColor  {
    val primary = Color(0xff7DE2D1)
    val lightPrimary = Color(0xffB5EEC4)
    val fontBlack = Color(0xff191D21)

    val bgGradient = androidx.compose.ui.graphics.Brush.linearGradient(
        colors = listOf(
            Color(0xff7DE2D1),
            Color(0xff9BEADC),
            Color(0xff16C2A5)
        ),
    )
}