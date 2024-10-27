package com.example.medicaonlinedoctor.view.splash_viewpager

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.medicaonlinedoctor.getList
import com.example.medicaonlinedoctor.ui.theme.maintext
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun IntroScreen(navController: NavController) {

    val pagerState = rememberPagerState()
    val list = getList()

    val isNextVisible = remember { derivedStateOf { pagerState.currentPage != list.size - 1 } }
    val isPrevVisible = remember { derivedStateOf { pagerState.currentPage != 0 } }

    val scope = rememberCoroutineScope()

    Box(modifier = Modifier)
    {


        AsyncImage(
            model = list[pagerState.currentPage].res,
            contentDescription = null,
            contentScale = ContentScale.Crop, // Ekranni to'liq to'ldiradi
            modifier = Modifier.fillMaxHeight(0.8f),
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(5f)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(4f)
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(Color.White)
                    .padding( horizontal = 20.dp, vertical = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                HorizontalPager(
                    state = pagerState,
                    verticalAlignment = Alignment.CenterVertically,
                    count = list.size
                ) { currentPage ->

                    Text(
                        text = list[currentPage].description,
                        color = maintext,
                        fontSize = 35.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(
                                CenterHorizontally
                            ),
                    )

                }
                HorizontalPagerIndicator(
                    pagerState = pagerState, modifier = Modifier
                        .padding(vertical = 26.dp)
                    ,
                    activeColor = maintext, // Bosilgan indikator uchun qizil rang
                    inactiveColor = Color.LightGray,          // Oddiy indikator uchun kul rang
                    indicatorWidth = 6.dp,                    // Oddiy indikator uzunligi
                    indicatorHeight = 6.dp,                   // Oddiy indikator balandligi
                    indicatorShape = RoundedCornerShape(50)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    if (isNextVisible.value) {
                        Button(onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = maintext // Tugma uchun qora rang
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .clip(RoundedCornerShape(30.dp)))

                        {
                            Text(text = "${list[pagerState.currentPage].title}",
                                modifier = Modifier
                                    .background(Color.Transparent),
                                color = Color.White

                            )

                        }
                    }
                    else
                    {
                        Button(onClick = {
                            navController.navigate("SignInorUp")
                        },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = maintext // Tugma uchun qora rang
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .clip(RoundedCornerShape(30.dp)))

                        {
                            Text(text = "${list[pagerState.currentPage].title}",
                                modifier = Modifier
                                    .background(Color.Transparent),
                                color = Color.White

                            )

                        }
                    }
                }
            }

        }
    }
}
