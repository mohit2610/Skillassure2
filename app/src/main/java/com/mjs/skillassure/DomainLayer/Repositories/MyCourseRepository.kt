package com.mjs.skillassure.DomainLayer.Repositories

import com.mjs.skillassure.DataLayer.MyCourseData
import com.mjs.skillassure.R

class MyCourseRepository {
    companion object {
        fun setMyCourseData(): List<MyCourseData> {
            val mcData = ArrayList<MyCourseData>()
            mcData.add(MyCourseData(R.drawable.pic, "Java", "22 march", "220 mints"))
            mcData.add(MyCourseData(R.drawable.pic, "Java", "22 march", "220 mints"))
            mcData.add(MyCourseData(R.drawable.pic, "Java", "22 march", "220 mints"))
            mcData.add(MyCourseData(R.drawable.pic, "Java", "22 march", "220 mints"))
            mcData.add(MyCourseData(R.drawable.pic, "Java", "22 march", "220 mints"))
            mcData.add(MyCourseData(R.drawable.pic, "Java", "22 march", "220 mints"))
            mcData.add(MyCourseData(R.drawable.pic, "Java", "22 march", "220 mints"))
            mcData.add(MyCourseData(R.drawable.pic, "Java", "22 march", "220 mints"))
            return mcData
        }
    }
}