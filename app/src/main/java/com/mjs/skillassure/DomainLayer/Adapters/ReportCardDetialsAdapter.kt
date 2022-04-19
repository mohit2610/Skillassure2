package com.mjs.skillassure.DomainLayer.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mjs.skillassure.DataLayer.ReportCardDetialsData
import com.mjs.skillassure.DomainLayer.Adapters.DiffUtills.MyReportCardDiff
import com.mjs.skillassure.DomainLayer.Adapters.DiffUtills.ReportCardDetialsDiff
import com.mjs.skillassure.databinding.ActivityMyReportCardDetailsBinding
import com.mjs.skillassure.databinding.MyReportCardViewBinding
import com.mjs.skillassure.databinding.ReportCardDetialsViewBinding

class ReportCardDetialsAdapter(val context: Context):RecyclerView.Adapter<ReportCardDetailsViewHolder>(){
    private val rcdList = mutableListOf<ReportCardDetialsData>()
    fun setData(newList: List<ReportCardDetialsData>){
        val diffUtil = ReportCardDetialsDiff(rcdList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil, true)
        rcdList.clear()
        rcdList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportCardDetailsViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = ReportCardDetialsViewBinding.inflate(inflator, parent, false)
        return ReportCardDetailsViewHolder(binding, context)
    }

    override fun onBindViewHolder(holder: ReportCardDetailsViewHolder, position: Int) {
       val list=rcdList[position]
        holder.binding.question.text=list.question
        holder.binding.foxWrongAnswer.text=list.wrongAnser
        holder.binding.correctAnswer.text=list.correctAnswer
    }

    override fun getItemCount(): Int {
      return  rcdList.size
    }
}
class ReportCardDetailsViewHolder(val binding:ReportCardDetialsViewBinding,val context: Context):RecyclerView.ViewHolder(binding.root){

}