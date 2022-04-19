package com.mjs.skillassure.PresentationLayer.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mjs.skillassure.Common.Common
import com.mjs.skillassure.Common.Constants
import com.mjs.skillassure.DataLayer.ReportCardDetialsData
import com.mjs.skillassure.DomainLayer.Adapters.ReportCardDetialsAdapter
import com.mjs.skillassure.R
import com.mjs.skillassure.databinding.ActivityMyReportCardDetailsBinding
import com.mjs.skillassure.databinding.MyReportCardViewBinding

class MyReportCardDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyReportCardDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMyReportCardDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Common.statusBar(this,window)
        binding.include4.moveBack.setOnClickListener{
            onBackPressed()
        }
        binding.include4.headerTitle.text=Constants.ReportCard

        val reportCardDetialsData1 = ReportCardDetialsData("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "Lorem", "ipsum")
        val reportCardDetialsData2 = ReportCardDetialsData("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "dolor", "Lorem")
        val reportCardDetialsData3 = ReportCardDetialsData("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "Lorem", "elit")


        val reportCardDetialsAdapter = ReportCardDetialsAdapter(this)
        reportCardDetialsAdapter.setData(listOf(
            reportCardDetialsData1,reportCardDetialsData2,reportCardDetialsData3
        ))

        binding.apply {
            anserRecyclerView.layoutManager=LinearLayoutManager(this@MyReportCardDetailsActivity,LinearLayoutManager.VERTICAL,true)
            anserRecyclerView.adapter=reportCardDetialsAdapter
        }

    }
}