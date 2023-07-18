package com.cxq.brushandroid.presentation.component


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.cxq.brushandroid.R


@Composable
fun Bg(@DrawableRes id: Int, content: @Composable BoxScope.() -> Unit = {}) {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = id),
            contentScale = ContentScale.FillBounds,
            contentDescription = null
        )
        content()
    }
}

@Preview
@Composable
fun BgPreview() {
    Bg(R.drawable.start_bg) {

    }
}

