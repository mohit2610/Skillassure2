package com.mjs.skillassure.DomainLayer.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mjs.skillassure.DataLayer.CategoryItems
import com.mjs.skillassure.DataLayer.MyCourseData
import com.mjs.skillassure.DomainLayer.Adapters.DiffUtills.MyCategoryDiff
import com.mjs.skillassure.DomainLayer.Adapters.DiffUtills.MyCourseDiff
import com.mjs.skillassure.PresentationLayer.Activities.MyCourseActivity
import com.mjs.skillassure.databinding.MyCourseViewBinding

class MyCourseAdapter(private val context: Context) :
    RecyclerView.Adapter<MyCourseViewHolder>() {
    private var myCourseList = mutableListOf<MyCourseData>()

    fun setData(newList: List<MyCourseData>) {
        val diffUtil = MyCourseDiff(myCourseList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil, true)
        myCourseList.clear()
        myCourseList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCourseViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = MyCourseViewBinding.inflate(inflator, parent, false)
        return MyCourseViewHolder(binding, context)
    }

    override fun onBindViewHolder(holder: MyCourseViewHolder, position: Int) {
        val cItems = myCourseList[position]
        holder.binding.courseName.text = cItems.courseName
        holder.binding.courseDate.text = cItems.courseDate
        holder.binding.courseTime.text = cItems.courseTime
        Glide.with(context).load(cItems.imageUrl).into(holder.binding.courseImg)
    }

    override fun getItemCount(): Int {
        return myCourseList.size
    }
}

class MyCourseViewHolder(val binding: MyCourseViewBinding, private val context: Context) :
    RecyclerView.ViewHolder(binding.root) {
    init {
        itemView.isClickable = true;
        itemView.setOnClickListener {
            context.startActivity(Intent(context, MyCourseActivity::class.java))
        }
    }
}