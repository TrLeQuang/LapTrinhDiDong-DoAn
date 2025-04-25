package com.example.nearbystore.Activites.Screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.nearbystore.Activites.SignIn.SignInActivity
import com.example.nearbystore.R
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ProfileScreen(name: String, email: String, photoUrl: String) {
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        // Nền xanh phía trên
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(color = colorResource(id = R.color.blue))
        ) {
            Image(
                painter = painterResource(id = R.drawable.building),
                contentDescription = null,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }

        // Ảnh đại diện chồng lên
        Box(
            modifier = Modifier
                .offset(y = (-60).dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = photoUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.White, CircleShape)
                    .padding(4.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Vùng trắng chứa thông tin
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = email, fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    FirebaseAuth.getInstance().signOut()
                    context.startActivity(Intent(context, SignInActivity::class.java))
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .fillMaxWidth()
            ) {
                Text("Sign Out")
            }
        }
    }
}
