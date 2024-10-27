package com.example.medicaonlinedoctor.view.splash_viewpager

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.medicaonlinedoctor.R
import com.example.medicaonlinedoctor.view.DotsSequentialFlashingCircle
import kotlinx.coroutines.delay

@Composable
fun Splash(navController: NavController){
    LaunchedEffect(Unit) {
        delay(5000) // 3 soniya kutish
        navController.navigate("splash2") // Splash 2 ekranga o'tish
    }
    Box(modifier = Modifier.fillMaxSize())
    {
        Image(painter = painterResource(id = R.drawable.splash), contentDescription ="", modifier = Modifier.align(Alignment.Center).padding(40.dp) )
        DotsSequentialFlashingCircle(modifier = Modifier.size(200.dp).align(Alignment.BottomCenter))
    }
}
