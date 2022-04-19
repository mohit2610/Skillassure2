package com.mjs.skillassure.DomainLayer.Repositories

import com.mjs.skillassure.DataLayer.AssessmentTestData

class AssessmentTestRepository {
    companion object{
        fun setAssessmentTestData():List<AssessmentTestData>{
            val questionsList=ArrayList<AssessmentTestData>()
            questionsList.add(AssessmentTestData("Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "A",
                "B",
                "C",
                "D"))

            questionsList.add(AssessmentTestData("Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "A",
                "B",
                "C",
                "D"))

            questionsList.add(AssessmentTestData("Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "A",
                "B",
                "C",
                "D"))

            questionsList.add(AssessmentTestData("Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "A",
                "B",
                "C",
                "D"))

            questionsList.add(AssessmentTestData("Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "A",
                "B",
                "C",
                "D"))
            return questionsList
        }
    }
}