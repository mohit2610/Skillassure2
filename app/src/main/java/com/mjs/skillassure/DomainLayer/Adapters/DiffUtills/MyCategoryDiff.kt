package com.mjs.skillassure.DomainLayer.Adapters.DiffUtills

import androidx.recyclerview.widget.DiffUtil
import com.mjs.skillassure.DataLayer.CategoryItems

class MyCategoryDiff(
    private val oldList: List<CategoryItems>,
    private val NewList: List<CategoryItems>
    ) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return NewList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].categoryIcon == NewList[newItemPosition].categoryIcon
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].categoryIcon != NewList[newItemPosition].categoryIcon -> {
                false
            }
            oldList[oldItemPosition].categoryIcon != NewList[newItemPosition].categoryIcon -> {
                false
            }
            else -> true
        }
    }

}