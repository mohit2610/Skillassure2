package com.mjs.skillassure.DomainLayer.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mjs.skillassure.DataLayer.MyCourseData
import com.mjs.skillassure.DomainLayer.Repositories.MyCourseRepository

class MyCourseViewModel:ViewModel() {
    val myCourseViewModel : MutableLiveData<List<MyCourseData>> = MutableLiveData()
    fun getMyCourseData(){
        val response =MyCourseRepository.setMyCourseData()
        myCourseViewModel.value=response
    }
}