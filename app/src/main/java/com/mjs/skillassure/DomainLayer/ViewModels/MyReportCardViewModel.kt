package com.mjs.skillassure.DomainLayer.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mjs.skillassure.DataLayer.ReportCardData
import com.mjs.skillassure.DomainLayer.Repositories.MyReportCardRepository

class MyReportCardViewModel:ViewModel() {
    val reportCardViewModel:MutableLiveData<List<ReportCardData>> = MutableLiveData()

    fun getReportCardData(){
        val response=MyReportCardRepository.setReportCardData()
        reportCardViewModel.value=response
    }
}