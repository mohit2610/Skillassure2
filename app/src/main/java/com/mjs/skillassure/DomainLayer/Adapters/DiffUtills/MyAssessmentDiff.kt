package com.mjs.skillassure.DomainLayer.Adapters.DiffUtills

import androidx.recyclerview.widget.DiffUtil
import com.mjs.skillassure.DataLayer.CategoryItems
import com.mjs.skillassure.DataLayer.MyAssessmentData

class MyAssessmentDiff(
    private val oldList: List<MyAssessmentData>,
    private val NewList: List<MyAssessmentData>,
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return NewList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].assessmentName == NewList[newItemPosition].assessmentName
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].imageUrl != NewList[newItemPosition].imageUrl -> {
                false
            }
            oldList[oldItemPosition].assessmentName != NewList[newItemPosition].assessmentName -> {
                false
            }
            oldList[oldItemPosition].assessmentDate != NewList[newItemPosition].assessmentDate -> {
                false
            }
            oldList[oldItemPosition].assessmentTime != NewList[newItemPosition].assessmentTime -> {
                false
            }
            else -> true
        }
    }

}