package com.mjs.skillassure.DomainLayer.Adapters.DiffUtills

import androidx.recyclerview.widget.DiffUtil
import com.mjs.skillassure.DataLayer.MyCourseData

class MyCourseDiff(
    val oldList: List<MyCourseData>,
    val newList: List<MyCourseData>
):DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].courseName == newList[newItemPosition].courseName
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].courseName!=newList[newItemPosition].courseName->{
                false
            }
            oldList[oldItemPosition].courseDate!=newList[newItemPosition].courseDate->{
                false
            }
            oldList[oldItemPosition].imageUrl!=newList[newItemPosition].imageUrl->{
                false
            }
            oldList[oldItemPosition].courseTime!=newList[newItemPosition].courseTime->{
                false
            }
            else->{
                true
            }
        }
    }
}