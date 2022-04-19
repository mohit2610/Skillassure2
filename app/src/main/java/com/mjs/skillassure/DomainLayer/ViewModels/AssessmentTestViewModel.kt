package com.mjs.skillassure.DomainLayer.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mjs.skillassure.DataLayer.AssessmentTestData
import com.mjs.skillassure.DomainLayer.Repositories.AssessmentTestRepository

class AssessmentTestViewModel:ViewModel() {
    val assessmentTestViewModel : MutableLiveData<List<AssessmentTestData>> = MutableLiveData()
    fun getAssessmentTestData(){
        val response= AssessmentTestRepository.setAssessmentTestData()
        assessmentTestViewModel.value=response
    }
}