package com.example.medicaonlinedoctor.view.sign

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
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.medicaonlinedoctor.R
import com.example.medicaonlinedoctor.ui.theme.maintext
import com.example.medicaonlinedoctor.ui.theme.scalecolor
import okhttp3.internal.wait

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignIn(navController: NavController){
    var adress by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.back1),
                    contentDescription = "",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            navController.navigate("SignInorUp")
                        },
                    alignment = Alignment.CenterStart
                )
            }
            Image(painter = painterResource(id = R.drawable.signin), contentDescription = "", modifier = Modifier
                .fillMaxWidth()
                .height(200.dp))
            Text(
                text = "Login to Your Account",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier,
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.padding(top = 20.dp))
            OutlinedTextField(
                value = adress,
                onValueChange = { adress = it },
                placeholder = { Text("Enter Your email") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(15.dp),
                textStyle = TextStyle(color = Color.Black),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email, // o'zingizning ikonkangizni qo'shing
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                },
                colors = androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = maintext,       // Active holatda chegara rangi
                    unfocusedBorderColor = Color.Transparent,     // Inactive holatda chegara rangi
                    cursorColor = maintext,              // Cursor rangi
                    focusedPlaceholderColor = Color.LightGray,    // Placeholder rangi
                    focusedLeadingIconColor = Color.Black,  // Active holatda ikon rang
                    unfocusedLeadingIconColor = Color.Gray ,// Inactive holatda ikon rang
                    containerColor = scalecolor,

                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = password,
                maxLines = 1,
                onValueChange = { password = it },
                placeholder = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                shape = RoundedCornerShape(15.dp),
                textStyle = TextStyle(color = Color.Black),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock, // o'zingizning ikonkangizni qo'shing
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                },
                trailingIcon = {
                    val description = if (passwordVisible) "Hide password" else "Show password"
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        val image =
                            if (passwordVisible) R.drawable.baseline_remove_red_eye_24 else R.drawable.hide
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = image),
                            contentDescription = description
                        )
                    }
                },
                colors = androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = maintext,       // Active holatda chegara rangi
                    unfocusedBorderColor = Color.Transparent,     // Inactive holatda chegara rangi
                    cursorColor = maintext,              // Cursor rangi
                    focusedPlaceholderColor = Color.LightGray,    // Placeholder rangi
                    focusedLeadingIconColor = Color.Black,  // Active holatda ikon rang
                    unfocusedLeadingIconColor = Color.Gray ,// Inactive holatda ikon rang
                    focusedTrailingIconColor = Color.Black, // Active holatda o'ng ikon rang
                    unfocusedTrailingIconColor = Color.Gray,
                    containerColor = scalecolor,

                    )
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = maintext// Tugma rangini yashil qilib qo'yish
                )
            ) {
                Text("Sign in", color = Color.White) // Matn rangini oq qilib qo'yish
            }
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Text(
                text = "Forgot the password?",
                modifier = Modifier,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = maintext
            )
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
                    text = " or continue with ",
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 8.dp), // Matnni chiziqdan bir oz ajratish
                )
                Divider(
                    color = Color.Gray,
                    modifier = Modifier.weight(1f) // Chiziqning kengligini belgilaydi
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(modifier = Modifier.fillMaxWidth()){
                Spacer(modifier = Modifier.weight(1f))
                Box(modifier = Modifier
                    .height(60.dp)
                    .weight(3f)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(15.dp)) // Qizil chegara qo'shish
                    ,){
                    Image(painter = painterResource(id = R.drawable.facebook1), contentDescription ="", modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.Center) )
                }
                Spacer(modifier = Modifier.weight(1f))
                Box(modifier = Modifier
                    .height(60.dp)
                    .weight(3f)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(15.dp)) // Qizil chegara qo'shish
                    ,){
                    Image(painter = painterResource(id = R.drawable.google1), contentDescription ="", modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.Center) )
                }
                Spacer(modifier = Modifier.weight(1f))

                Box(modifier = Modifier
                    .height(60.dp)
                    .weight(3f)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(15.dp)) // Qizil chegara qo'shish
                    ,){
                    Image(painter = painterResource(id = R.drawable.apple1), contentDescription ="", modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.Center) )
                }
                Spacer(modifier = Modifier.weight(1f))

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
                    modifier = Modifier
                        .clickable {
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


