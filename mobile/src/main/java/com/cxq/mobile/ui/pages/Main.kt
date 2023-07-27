package com.cxq.mobile.ui.pages


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cxq.mobile.R
import com.cxq.mobile.ui.component.LogoButton
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun Main(navToBrush: () -> Unit) {
    val pageState = rememberPagerState(
        initialPage = 0, initialPageOffsetFraction = 0f
    ) { 2 }

    val scope = rememberCoroutineScope()
    Scaffold(
        bottomBar = {
            BottomBar(pageState.currentPage, navToBrush) { index ->
                scope.launch {
                    pageState.animateScrollToPage(index)
                }
            }
        },
    ) {
        HorizontalPager(
            modifier = Modifier
                .navigationBarsPadding()
                .padding(bottom = 70.dp),
            state = pageState
        ) {
            when (it) {
                0 -> Analysis()
                1 -> Mine()
            }
        }
    }
}

@Composable
private fun BottomBar(
    selectedPage: Int,
    navToBrush: () -> Unit,
    onSelect: (Int) -> Unit
) {
    val bottomIdUn: List<Int> = listOf(R.drawable.analysis0, R.drawable.mine0)
    val bottomIdEd: List<Int> = listOf(R.drawable.analysis1, R.drawable.mine1)

    Row(Modifier.navigationBarsPadding()) {
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .weight(4f)
                .height(70.dp)
                .clip(RoundedCornerShape(35.dp))
                .background(color = Color(0xff99C7C2).copy(alpha = 0.38f)),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1f))
                listOf(0, 1).forEach { index ->
                    Spacer(modifier = Modifier.weight(0.5f))
                    Image(
                        modifier = Modifier
                            .size(35.dp)
                            .padding(
                                animateDpAsState(targetValue = if (selectedPage == index) 0.dp else 5.dp).value
                            )
                            .clickable(
                                indication = null,
                                interactionSource = remember {
                                    MutableInteractionSource()
                                },
                                onClick = {
                                    onSelect(index)
                                }),
                        painter =
                        painterResource(id = if (selectedPage == index) bottomIdEd[index] else bottomIdUn[index]),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.weight(0.5f))

                    if (index == 0) {
                        Spacer(modifier = Modifier.weight(0.5f))
                        LogoButton(onClick = navToBrush)
                        Spacer(modifier = Modifier.weight(0.5f))
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
            }


        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

//@Composable
//fun LogoBtn() {
//    i
//}


@Preview
@Composable
fun MainPreview() {
    Main() {}
}