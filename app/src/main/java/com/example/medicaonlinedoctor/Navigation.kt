package com.example.medicaonlinedoctor

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.medicaonlinedoctor.view.sign.SignIn
import com.example.medicaonlinedoctor.view.sign.SignInorUp
import com.example.medicaonlinedoctor.view.sign.SignUp
import com.example.medicaonlinedoctor.view.splash_viewpager.IntroScreen
import com.example.medicaonlinedoctor.view.splash_viewpager.Splash
import com.example.medicaonlinedoctor.view.splash_viewpager.Splash2

@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "splash") {
        composable("splash") { Splash(navController) }
        composable("splash2") { Splash2(navController) }
        composable("main") { IntroScreen(navController) }
        composable("SignIn") { SignIn(navController) }
        composable("SignUp") { SignUp(navController) }
        composable("SignInorUp") { SignInorUp(navController) }

    }
}
