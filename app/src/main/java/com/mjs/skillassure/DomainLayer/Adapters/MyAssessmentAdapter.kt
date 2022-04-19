package com.mjs.skillassure.DomainLayer.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mjs.skillassure.DataLayer.CategoryItems
import com.mjs.skillassure.DataLayer.MyAssessmentData
import com.mjs.skillassure.DataLayer.MyCourseData
import com.mjs.skillassure.DomainLayer.Adapters.DiffUtills.MyAssessmentDiff
import com.mjs.skillassure.DomainLayer.Adapters.DiffUtills.MyCategoryDiff
import com.mjs.skillassure.PresentationLayer.Activities.PrerequistieActivity
import com.mjs.skillassure.databinding.MyAssessmentViewBinding
import com.mjs.skillassure.databinding.MyCourseViewBinding

class MyAssessmentAdapter(
    private val context: Context,
) :
    RecyclerView.Adapter<MyAssessmentViewHolder>() {
    private val assessmentItemList = mutableListOf<MyAssessmentData>()
    fun setData(newList: List<MyAssessmentData>) {
        val diffUtil = MyAssessmentDiff(assessmentItemList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil, true)
        assessmentItemList.clear()
        assessmentItemList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAssessmentViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = MyAssessmentViewBinding.inflate(inflator, parent, false)
        return MyAssessmentViewHolder(binding, context)
    }

    override fun onBindViewHolder(holder: MyAssessmentViewHolder, position: Int) {
        val cItems = assessmentItemList[position]
        holder.binding.assessmentName.text = cItems.assessmentName
        holder.binding.assessmentDate.text = cItems.assessmentDate
        holder.binding.assessmentTime.text = cItems.assessmentTime
        Glide.with(context).load(cItems.imageUrl).into(holder.binding.assessmentImg)
    }

    override fun getItemCount(): Int {
        return assessmentItemList.size
    }
}

class MyAssessmentViewHolder(val binding: MyAssessmentViewBinding, private val context: Context) :
    RecyclerView.ViewHolder(binding.root) {
    init {
        itemView.isClickable = true;
        itemView.setOnClickListener {
            context.startActivity(Intent(context, PrerequistieActivity::class.java))
        }
    }
}