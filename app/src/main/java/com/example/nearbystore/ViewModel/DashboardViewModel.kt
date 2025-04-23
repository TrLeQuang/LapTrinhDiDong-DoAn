package com.example.nearbystore.ViewModel

import androidx.lifecycle.LiveData
import com.example.nearbystore.Domain.BannerModel
import com.example.nearbystore.Domain.CategoryModel

class DashboardViewModel {
    private val repository = DashboardViewModel()

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        return repository.loadCategory()
    }

    fun loadBanners(): LiveData<MutableList<BannerModel>> {
        return repository.loadBanners()
    }
}