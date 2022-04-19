package com.mjs.skillassure.DomainLayer.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mjs.skillassure.DataLayer.CategoryItems
import com.mjs.skillassure.DomainLayer.Adapters.DiffUtills.MyCategoryDiff
import com.mjs.skillassure.PresentationLayer.Activities.ui.home.HomeFragment
import com.mjs.skillassure.databinding.MyCategoriesViewsBinding

class MyCategoriesAdapter(var context: Context): RecyclerView.Adapter<MyCategoriesViewHolder>() {
    private var categoryItem= mutableListOf<CategoryItems>()

    fun setData(newList:List<CategoryItems>){
        val diffUtil=MyCategoryDiff(categoryItem,newList)
        val diffResult=DiffUtil.calculateDiff(diffUtil,true)
        categoryItem.clear()
        categoryItem.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCategoriesViewHolder {
        val inflator=LayoutInflater.from(parent.context)
        val binding =MyCategoriesViewsBinding.inflate(inflator,parent,false)
        return MyCategoriesViewHolder(binding,context)
    }

    override fun onBindViewHolder(holder: MyCategoriesViewHolder, position: Int) {
       holder.bind(categoryItem[position])
    }
    override fun getItemCount(): Int {
        return categoryItem.size
    }
}
class MyCategoriesViewHolder(val  binding: MyCategoriesViewsBinding,val context: Context ):RecyclerView.ViewHolder(binding.root),View.OnClickListener{
    init {
        itemView.setOnClickListener(this)
        itemView.isClickable = true;
    }

    fun bind(categoryItems : CategoryItems){
        with(binding){
            cName.text=categoryItems.categoryName
            Glide.with(context).load(categoryItems.categoryIcon).into(binding.cIcon)
        }
    }

    override fun onClick(v: View?) {
        when(layoutPosition){
            0->{
                Toast.makeText(context,"clicked on 1",Toast.LENGTH_SHORT).show();
            }
            1->{
                Toast.makeText(context,"clicked on 2",Toast.LENGTH_SHORT).show();
            }
            2->{
                Toast.makeText(context,"clicked on 3",Toast.LENGTH_SHORT).show();
            }
            3->{
                Toast.makeText(context,"clicked on 4",Toast.LENGTH_SHORT).show();
            }
            4->{
                Toast.makeText(context,"clicked on 5",Toast.LENGTH_SHORT).show();
            }
            5->{
                Toast.makeText(context,"clicked on 6",Toast.LENGTH_SHORT).show();
            }
        }
    }
}