package com.example.nearbystore.ViewModel

import androidx.lifecycle.LiveData
import com.example.nearbystore.Domain.CategoryModel
import com.example.nearbystore.Domain.StoreModel
import com.example.nearbystore.Repository.ResultsRepository

class ResultsViewModel {
    private val repository = ResultsRepository()

    fun loadSubCategory(id: String): LiveData<MutableList<CategoryModel>> {
        return repository.loadSubCategory(id)
    }

    fun loadPopular(id: String): LiveData<MutableList<StoreModel>> {
        return repository.loadPopular(id)
    }

    fun loadNearest(id: String): LiveData<MutableList<StoreModel>> {
        return repository.loadNearest(id)
    }
}