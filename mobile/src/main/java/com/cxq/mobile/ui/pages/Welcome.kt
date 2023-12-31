package com.cxq.mobile.ui.pages


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cxq.mobile.R
import com.cxq.mobile.ui.component.LogoButton


@Composable
fun Welcome(onNavToEnter: () -> Unit = { }) {
    Box(contentAlignment = Alignment.BottomCenter) {
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.welcome),
            contentDescription = null
        )
        LogoButton(Modifier.padding(bottom = 120.dp), onClick = onNavToEnter)
    }
}

@Preview
@Composable
fun WelcomePreview() {
    Welcome()
}