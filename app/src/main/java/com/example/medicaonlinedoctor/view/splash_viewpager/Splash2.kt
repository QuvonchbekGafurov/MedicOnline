package com.example.medicaonlinedoctor.view.splash_viewpager

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.medicaonlinedoctor.R
import kotlinx.coroutines.delay

@Composable
fun Splash2(navController: NavController){
    LaunchedEffect(Unit) {
        delay(5000) // 3 soniya kutish
        navController.navigate("main") // MainScreen ekranga o'tish
    }

    Column (modifier = Modifier.fillMaxSize()){
      Image(painter = painterResource(id = R.drawable.splash2)
          , contentDescription ="",
          modifier = Modifier
              .fillMaxWidth()
              .weight(3f)
      )
      Image(painter = painterResource(id = R.drawable.splash2text)
          , contentDescription ="",
          modifier = Modifier
              .fillMaxWidth()
              .weight(2f)
      )
  }
}

