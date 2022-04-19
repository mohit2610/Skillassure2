package com.mjs.skillassure.DomainLayer.Adapters.DiffUtills

import androidx.recyclerview.widget.DiffUtil
import com.mjs.skillassure.DataLayer.ReportCardDetialsData

class ReportCardDetialsDiff(
    private val oldList:List<ReportCardDetialsData>,
    private val newList: List<ReportCardDetialsData>
):DiffUtil.Callback (){
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].question == newList[newItemPosition].question
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].question!=newList[newItemPosition].question->{
                false
            }
            oldList[oldItemPosition].correctAnswer!=newList[newItemPosition].correctAnswer->{
                false
            }
            oldList[oldItemPosition].wrongAnser!=newList[newItemPosition].wrongAnser->{
                false
            }
            else->true
        }
    }
}