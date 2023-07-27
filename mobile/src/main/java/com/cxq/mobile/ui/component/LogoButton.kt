package com.cxq.mobile.ui.component

/**
 * @author CXQ
 * @date 2023/7/27
 */
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cxq.mobile.R

@Composable
fun LogoButton(modifier: Modifier = Modifier ,onClick: () -> Unit = {}) {
    TextButton(
        modifier = modifier
            .size(60.dp),
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp),
        onClick = onClick
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null
        )
    }
}

