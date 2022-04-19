package com.mjs.skillassure.DomainLayer.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mjs.skillassure.DataLayer.MyAssessmentData
import com.mjs.skillassure.DomainLayer.Repositories.MyAssessmentRepository

class MyAssessmentViewModel:ViewModel() {
    val assessmentViewModel :MutableLiveData<List<MyAssessmentData>> = MutableLiveData()
    fun getAssessment(){
        val response =MyAssessmentRepository.setMyAssessmentData()
        assessmentViewModel.value=response
    }
}