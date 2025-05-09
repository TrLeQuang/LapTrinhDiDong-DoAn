package com.example.nearbystore.Activites.Dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.navigation.compose.*
import com.example.nearbystore.Activites.Navigation.Screen
import com.example.nearbystore.R
import com.example.nearbystore.Activites.Screens.*
import com.example.nearbystore.Activites.Dashboard.MyBottomBar
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val currentUser = FirebaseAuth.getInstance().currentUser
        val displayName = currentUser?.displayName ?: "User"
        val photoUrl = currentUser?.photoUrl?.toString() ?: ""
        val email = currentUser?.email ?: ""

        setContent {
            val navController = rememberNavController()

            Scaffold(
                bottomBar = {
                    MyBottomBar(navController = navController)
                }
            ) { paddingValues ->
                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route,
                    modifier = Modifier.padding(paddingValues)
                ) {
                    composable(Screen.Home.route) {
                        HomeScreen(displayName, photoUrl)
                    }
                    composable(Screen.Support.route) {
                        SupportScreen()
                    }
                    composable(Screen.Wishlist.route) {
                        WishlistScreen()
                    }
                    composable(Screen.Profile.route) {
                        ProfileScreen(displayName, email, photoUrl)
                    }
                }
            }
        }
    }
}