package com.example.nearbystore.Activites.Navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Support : Screen("support")
    object Wishlist : Screen("wishlist")
    object Profile : Screen("profile")
}