package com.mjs.skillassure.DomainLayer.Repositories

import com.mjs.skillassure.DataLayer.MyAssessmentData
import com.mjs.skillassure.R

class MyAssessmentRepository {
    companion object{
        fun setMyAssessmentData():List<MyAssessmentData>{
            val maData=ArrayList<MyAssessmentData>()
            maData.add(MyAssessmentData(R.drawable.pic2, "Oops", "22 march", "220 mints"))
            maData.add(MyAssessmentData(R.drawable.pic2, "Oops", "22 march", "220 mints"))
            maData.add(MyAssessmentData(R.drawable.pic2, "Oops", "22 march", "220 mints"))
            maData.add(MyAssessmentData(R.drawable.pic2, "Oops", "22 march", "220 mints"))
            maData.add(MyAssessmentData(R.drawable.pic2, "Oops", "22 march", "220 mints"))
            maData.add(MyAssessmentData(R.drawable.pic2, "Oops", "22 march", "220 mints"))
            maData.add(MyAssessmentData(R.drawable.pic2, "Oops", "22 march", "220 mints"))
            maData.add(MyAssessmentData(R.drawable.pic2, "Oops", "22 march", "220 mints"))
            maData.add(MyAssessmentData(R.drawable.pic2, "Oops", "22 march", "220 mints"))
            return maData
        }
    }
}