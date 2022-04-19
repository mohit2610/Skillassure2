package com.mjs.skillassure.DomainLayer.Repositories

import com.mjs.skillassure.DataLayer.ReportCardData

class MyReportCardRepository {
    companion object {
        fun setReportCardData(): List<ReportCardData> {
            val correctPercentage1 = percentageCalculator(7, 10)
            val correctPercentage2 = percentageCalculator(7, 15)
            val correctPercentage3 = percentageCalculator(25, 30)
            val correctPercentage4 = percentageCalculator(12, 15)
            val correctPercentage5 = percentageCalculator(8, 10)
            val correctPercentage6 = percentageCalculator(22, 25)
            val rcData = ArrayList<ReportCardData>()
            rcData.add(ReportCardData("Opps",
                "22 march 2022",
                " 90 mints",
                correctPercentage1,
                7,
                3))
            rcData.add(ReportCardData("Java",
                "22 march 2022",
                " 90 mints",
                correctPercentage2,
                7,
                8))
            rcData.add(ReportCardData("React",
                "22 march 2022",
                " 90 mints",
                correctPercentage3,
                25,
                5))
            rcData.add(ReportCardData("Kotlin",
                "22 march 2022",
                " 90 mints",
                correctPercentage4,
                12,
                3))
            rcData.add(ReportCardData("Java Script",
                "22 march 2022",
                " 90 mints",
                correctPercentage5,
                8,
                2))
            rcData.add(ReportCardData("Assure",
                "22 march 2022",
                " 90 mints",
                correctPercentage6,
                22,
                3))
            return rcData
        }

        fun percentageCalculator(correctAns: Int, totalQuestion: Int): Int {
            return correctAns * 100 / totalQuestion
        }
    }

}