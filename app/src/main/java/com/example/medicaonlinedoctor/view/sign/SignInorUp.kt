package com.example.medicaonlinedoctor.view.sign

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.medicaonlinedoctor.R
import com.example.medicaonlinedoctor.ui.theme.maintext

@Composable
fun SignInorUp(navController: NavController) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
           Box(modifier = Modifier
                .fillMaxWidth().clickable{
                   Log.e("TAG", "SignInorUp: Salom", )
               }
           ) {
                Image(
                    painter = painterResource(id = R.drawable.back1),
                    contentDescription = "",
                    modifier = Modifier
                        .size(35.dp)
                        .clickable {
                            Log.e("TAG", "SignInorUp: Salom", )
                        }
                        .zIndex(1f)
                    ,
                    alignment = Alignment.CenterStart
                )
            }
            Image(
                painter = painterResource(id = R.drawable.sign1),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Text(
                text = "Let’s you in",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.Transparent)
                    .border(
                        1.dp,
                        Color.LightGray,
                        RoundedCornerShape(15.dp)
                    ) // Qizil chegara qo'shish
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,// Vertikal markazga joylashtirish,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.facebook1),
                    contentDescription = "",
                    modifier = Modifier.size(40.dp)
                )
                Text(
                    text = "  Continue with Facebook ",
                    modifier = Modifier,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.Transparent)
                    .border(
                        1.dp,
                        Color.LightGray,
                        RoundedCornerShape(15.dp)
                    ) // Qizil chegara qo'shish
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,// Vertikal markazga joylashtirish,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.google1),
                    contentDescription = "",
                    modifier = Modifier.size(40.dp)
                )
                Text(
                    text = "  Continue with Google     ",
                    modifier = Modifier,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.Transparent)
                    .border(
                        1.dp,
                        Color.LightGray,
                        RoundedCornerShape(15.dp)
                    ) // Qizil chegara qo'shish
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,// Vertikal markazga joylashtirish,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.apple1),
                    contentDescription = "",
                    modifier = Modifier.size(40.dp)
                )
                Text(
                    text = "  Continue with Apple      ",
                    modifier = Modifier,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.padding(top = 20.dp))

            Row(

                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically // Vertikal markazga joylashtirish

            ) {
                Divider(
                    color = Color.Gray,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = " or ",
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 8.dp), // Matnni chiziqdan bir oz ajratish
                )
                Divider(
                    color = Color.Gray,
                    modifier = Modifier.weight(1f) // Chiziqning kengligini belgilaydi
                )
            }


            Spacer(modifier = Modifier.height(36.dp))
            Button(
                onClick = {
                    navController.navigate("SignIn")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = maintext// Tugma rangini yashil qilib qo'yish
                )
            ) {
                Text("Sign in with password", color = Color.White) // Matn rangini oq qilib qo'yish
            }

            Spacer(modifier = Modifier.height(30.dp))
            Row {
                Text(
                    text = "Don’t have an account?  ",
                    modifier = Modifier,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.LightGray
                )
                Text(
                    text = "Sign up?",
                    modifier = Modifier.clickable {
                        navController.navigate("SignUp")
                    },
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = maintext
                )
            }


        }
    }

}
