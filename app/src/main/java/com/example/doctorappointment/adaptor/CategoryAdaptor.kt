package com.example.doctorappointment.adaptor

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.doctorappointment.databinding.ViewholdercategoryBinding
import com.example.doctorappointment.domain.Category

class CategoryAdaptor(val context: Context , val list: List<Category>): RecyclerView.Adapter<CategoryAdaptor.ViewHolder>() {

    inner class ViewHolder(val binding: ViewholdercategoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdaptor.ViewHolder {
        val binding = ViewholdercategoryBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CategoryAdaptor.ViewHolder, position: Int) {
      val item = list[position]
        holder.binding.titleText.text = item.Name

        Glide.with(context)
            .load(item.Picture)
            .into(holder.binding.imgofTitle)
        Log.d("CategoryAdaptor", "Image URL = ${item.Picture}")

    }

    override fun getItemCount(): Int {
       return list.size
    }
}