package com.cxq.mobile.ui.pages


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cxq.mobile.R
import com.cxq.mobile.ui.theme.Typography

@Composable
fun Enter(navToMain: ()->Unit = {}) {
    val isLogin = remember { mutableStateOf(true) }
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Box(contentAlignment = Alignment.Center) {
        Column(
            Modifier
                .fillMaxSize()
                .background(
                    androidx.compose.ui.graphics.Brush.linearGradient(
                        colors = listOf(
                            Color(0xff7DE2D1),
                            Color(0xff9BEADC),
                            Color(0xff16C2A5)
                        ),
                    ),
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    modifier = Modifier
                        .weight(4f),
                    painter = painterResource(id = if (isLogin.value) R.drawable.login_bg else R.drawable.signup_bg),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                    .background(Color.White)
            ) {
                Spacer(modifier = Modifier.height(40.dp))
                Column(Modifier.padding(horizontal = 30.dp)) {
                    Text(
                        text = if (isLogin.value) "Hi There,\nWelcome back!" else "Hi There,\nHave an account!",
                        style = Typography.headlineLarge.copy(fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    LoginTextField(
                        value = username.value,
                        hint = "Enter Email",
                        onValueChange = { value ->
                            username.value = value
                        })
                    Spacer(modifier = Modifier.height(5.dp))
                    LoginTextField(
                        value = password.value,
                        hint = "Password",
                        onValueChange = { value ->
                            password.value = value
                        })
                    Text(
                        modifier = Modifier
                            .align(alignment = Alignment.End)
                            .padding(5.dp)
                            .clickable {
                                isLogin.value = !isLogin.value
                            },
                        text = if (isLogin.value) "Sign up" else "Log in",
                        color = Color.Gray
                    )
                    ElevatedButton(modifier = Modifier
                        .fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xff99EADC)),
                        onClick = {

                            navToMain()

                        }) {
                        Text(
                            text = if (isLogin.value) "Log in" else "Sign up",
                            style = Typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                        )
                    }
                }
            }
        }

        Image(
            modifier = Modifier
                .size(80.dp),
            painter = painterResource(id = if (isLogin.value) R.drawable.login_icon else R.drawable.signup_icon),
            contentDescription = null
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTextField(value: String, hint: String, onValueChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        placeholder = { Text(text = hint, color = Color.Gray) },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xffA1D6CD).copy(alpha = 0.26f),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
    )
}


@Preview(showSystemUi = true)
@Composable
fun LoginPreview() {
    Enter()
}