package com.mjs.skillassure.DomainLayer.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mjs.skillassure.DataLayer.ReportCardData
import com.mjs.skillassure.DomainLayer.Adapters.DiffUtills.MyReportCardDiff
import com.mjs.skillassure.PresentationLayer.Activities.MyReportCardDetailsActivity
import com.mjs.skillassure.databinding.MyReportCardViewBinding

class MyReportCardAdapter(val context: Context) : RecyclerView.Adapter<MyReportCardViewHolder>() {
    private var myReportCardList = mutableListOf<ReportCardData>()


    fun setData(newList: List<ReportCardData>) {
        val diffUtil = MyReportCardDiff(myReportCardList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil, true)
        myReportCardList.clear()
        myReportCardList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyReportCardViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = MyReportCardViewBinding.inflate(inflator, parent, false)
        return MyReportCardViewHolder(binding, context)
    }

    override fun onBindViewHolder(holder: MyReportCardViewHolder, position: Int) {
        val rcItems = myReportCardList[position]
        holder.binding.assessmentName.text = rcItems.assessmentName
        holder.binding.percentage.text = rcItems.correctPercentage.toString()
        holder.binding.assessmentDate.text = rcItems.date
        holder.binding.assessmentTime.text = rcItems.time
        holder.binding.correctAnsNum.text = rcItems.correctAns.toString()
        holder.binding.incorrectAnsNum.text = rcItems.incorrectAns.toString()
    }

    override fun getItemCount(): Int {
        return myReportCardList.size
    }
}

class MyReportCardViewHolder(val binding: MyReportCardViewBinding, val context: Context) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        itemView.isClickable = true;
        itemView.setOnClickListener {
            context.startActivity(Intent(context, MyReportCardDetailsActivity::class.java))
        }
    }
}