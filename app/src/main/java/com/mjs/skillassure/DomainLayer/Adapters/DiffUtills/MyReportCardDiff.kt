package com.mjs.skillassure.DomainLayer.Adapters.DiffUtills

import androidx.recyclerview.widget.DiffUtil
import com.mjs.skillassure.DataLayer.ReportCardData
import java.security.PrivateKey

class MyReportCardDiff(
    private val oldList: List<ReportCardData>,
    private val newList: List<ReportCardData>
):DiffUtil.Callback()
{
    override fun getOldListSize(): Int {
       return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return oldList[oldItemPosition].assessmentName==newList[newItemPosition].assessmentName
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
      return  when{
            oldList[oldItemPosition].assessmentName != newList[newItemPosition].assessmentName->{
                return false
            }
            oldList[oldItemPosition].date != newList[newItemPosition].date->{
                return false
            }
            oldList[oldItemPosition].time != newList[newItemPosition].time->{
                return false
            }
            oldList[oldItemPosition].correctPercentage != newList[newItemPosition].correctPercentage->{
                return false
            }
            oldList[oldItemPosition].correctAns != newList[newItemPosition].correctAns->{
                return false
            }
            oldList[oldItemPosition].incorrectAns != newList[newItemPosition].incorrectAns->{
                return false
            }
            else-> true
        }
    }

}