package com.cxq.brushandroid.presentation.theme

import androidx.compose.runtime.Composable
import androidx.wear.compose.material.MaterialTheme

@Composable
fun BrushAndroidTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = wearColor,
        typography = Typography,
        // For shapes, we generally recommend using the default Material Wear shapes which are
        // optimized for round and non-round devices.
        content = content,

    )
}