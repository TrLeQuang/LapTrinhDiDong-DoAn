package com.example.nearbystore.Activites.Dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.nearbystore.Activites.Navigation.Screen
import com.example.nearbystore.R

data class BottomMenuItem(val label: String, val icon: Painter, val route: String)

@Composable
fun MyBottomBar(navController: NavController) {
    val items = listOf(
        BottomMenuItem("Home", painterResource(R.drawable.btn_1), Screen.Home.route),
        BottomMenuItem("Support", painterResource(R.drawable.btn_2), Screen.Support.route),
        BottomMenuItem("Wishlist", painterResource(R.drawable.btn_3), Screen.Wishlist.route),
        BottomMenuItem("Profile", painterResource(R.drawable.btn_4), Screen.Profile.route)
    )

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    BottomAppBar(
        backgroundColor = colorResource(R.color.white),
        elevation = 3.dp
    ) {
        items.forEach { item ->
            val selected = currentRoute == item.route

            BottomNavigationItem(
                selected = selected,
                onClick = {
                    if (!selected) {
                        navController.navigate(item.route) {
                            launchSingleTop = true
                            restoreState = true
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                        }
                    }
                },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = item.icon,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .size(20.dp),
                            tint = if (selected) Color(0xFF2196F3) else colorResource(R.color.darkBrown)
                        )
                        Text(
                            text = item.label,
                            fontSize = 12.sp,
                            color = if (selected) Color(0xFF2196F3) else colorResource(R.color.darkBrown),
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            )
        }
    }
}
