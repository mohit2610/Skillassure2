package com.mjs.skillassure.DomainLayer.Adapters.DiffUtills

import androidx.recyclerview.widget.DiffUtil
import com.mjs.skillassure.DataLayer.AssessmentTestData
import com.mjs.skillassure.DataLayer.CategoryItems
import com.mjs.skillassure.DataLayer.MyAssessmentData

class MyAssessmentTestDiff(
    private val oldList: List<AssessmentTestData>,
    private val NewList: List<AssessmentTestData>,
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return NewList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].question == NewList[newItemPosition].question
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].options1 != NewList[newItemPosition].options1 -> {
                false
            }
            oldList[oldItemPosition].options2 != NewList[newItemPosition].options2 -> {
                false
            }
            oldList[oldItemPosition].options3 != NewList[newItemPosition].options3 -> {
                false
            }
            oldList[oldItemPosition].options4 != NewList[newItemPosition].options4 -> {
                false
            }
            else -> true
        }
    }

}