package com.mjs.skillassure.DomainLayer.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mjs.skillassure.DataLayer.CategoryItems
import com.mjs.skillassure.DomainLayer.Repositories.CategoryDataRepository

class CategoryViewModel: ViewModel() {
    val categoryViewModelLiveData :MutableLiveData<List<CategoryItems>> = MutableLiveData()

    fun getCategoryItem(){
        val response=CategoryDataRepository.setCategoryItem()
        categoryViewModelLiveData.value=response
    }
}