package com.example.medicaonlinedoctor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.medicaonlinedoctor.ui.theme.MedicaOnlineDoctorTheme
import com.example.medicaonlinedoctor.view.splash_viewpager.IntroScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MedicaOnlineDoctorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    val systemUi = rememberSystemUiController()
                    systemUi.setStatusBarColor(Color.Transparent)
                    AppNavigator()
                }
            }
        }
    }
}

data class HorizontalPagerContent(
    val title: String, @DrawableRes val res: Int, val description: String
)

fun getList(): List<HorizontalPagerContent> {
    return listOf(
        HorizontalPagerContent(
            "Next",
            R.drawable.img1,
            "Thousands of doctors & experts to help your health!"
        ),
        HorizontalPagerContent(
            "Next",
            R.drawable.img2,
            "Health checks & consultations easily anywhere anytime"
        ),
        HorizontalPagerContent(
            "Get Started",
            R.drawable.img3,
            "Let's start living healthy and well with us right now!"
        ),
    )
}


