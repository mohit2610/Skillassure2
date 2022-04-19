package com.mjs.skillassure.DomainLayer.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mjs.skillassure.DataLayer.AssessmentTestData
import com.mjs.skillassure.DataLayer.CategoryItems
import com.mjs.skillassure.DomainLayer.Adapters.DiffUtills.MyAssessmentTestDiff
import com.mjs.skillassure.DomainLayer.Adapters.DiffUtills.MyCategoryDiff
import com.mjs.skillassure.databinding.AssessmentTestViewBinding

class AssessmentTestAdapter(
    private val context: Context,
) :
    RecyclerView.Adapter<AssessmentTestViewHolder>() {

    private val listOfQuestions = mutableListOf<AssessmentTestData>()
    fun setData(newList: List<AssessmentTestData>) {
        val diffUtil = MyAssessmentTestDiff(listOfQuestions, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil, true)
        listOfQuestions.clear()
        listOfQuestions.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    private val seletedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssessmentTestViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = AssessmentTestViewBinding.inflate(inflator, parent, false)
        return AssessmentTestViewHolder(binding, context)
    }

    override fun onBindViewHolder(holder: AssessmentTestViewHolder, position: Int) {
        val listQuestions = listOfQuestions[position]
        holder.binding.question.text = listQuestions.question
        holder.binding.radioButton1.text = listQuestions.options1
        holder.binding.radioButton2.text = listQuestions.options2
        holder.binding.radioButton3.text = listQuestions.options3
        holder.binding.radioButton4.text = listQuestions.options4

        holder.binding.radioButton1.isChecked = position == seletedPosition
        holder.binding.radioButton2.isChecked = position == seletedPosition
        holder.binding.radioButton3.isChecked = position == seletedPosition
        holder.binding.radioButton4.isChecked = position == seletedPosition

    }

    override fun getItemCount() = listOfQuestions.size

    operator fun get(position: Int): AssessmentTestData = listOfQuestions[position]
}

class AssessmentTestViewHolder(val binding: AssessmentTestViewBinding, val context: Context) :
    RecyclerView.ViewHolder(binding.root) {
    private var selectedPosition = -1
    private val clickHandler: (View) -> Unit = {
        selectedPosition = adapterPosition
    }

    init {
        binding.apply {
            root.setOnClickListener(clickHandler)
            radioButton1.setOnClickListener(clickHandler)
            radioButton2.setOnClickListener(clickHandler)
            radioButton3.setOnClickListener(clickHandler)
            radioButton4.setOnClickListener(clickHandler)

        }
    }
}