package com.example.nearbystore.Activites.Dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.nearbystore.Domain.BannerModel
import com.example.nearbystore.Domain.CategoryModel
import com.example.nearbystore.R
import com.example.nearbystore.Repository.DashboardRepository

@Composable
fun DashboardScreen(displayName: String = "User", photoUrl: String = "") {
    val viewModel = DashboardRepository()

    val categories = remember { mutableStateListOf<CategoryModel>() }
    val banners = remember { mutableStateListOf<BannerModel>() }

    var showCategoryLoading by remember { mutableStateOf(true) }
    var showBannerLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        viewModel.loadCategory().observeForever {
            categories.clear()
            categories.addAll(it)
            showCategoryLoading = false
        }
    }

    LaunchedEffect(Unit) {
        viewModel.loadBanner().observeForever {
            banners.clear()
            banners.addAll(it)
            showBannerLoading = false
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.lightBlue))
            .padding(bottom = 60.dp) // thêm padding tránh che bởi BottomBar
    ) {
        item { TopBar(displayName = displayName, photoUrl = photoUrl) }
        item { CategorySection(categories, showCategoryLoading) }
        item { Banner(banners, showBannerLoading) }
    }
}
