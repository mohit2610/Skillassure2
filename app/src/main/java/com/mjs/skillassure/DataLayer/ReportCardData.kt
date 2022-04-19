package com.mjs.skillassure.DataLayer

import java.util.*

data class ReportCardData(
    val assessmentName: String,
    val date: String,
    val time: String,
    val correctPercentage: Int,
    val correctAns: Int,
    val incorrectAns: Int,
)
