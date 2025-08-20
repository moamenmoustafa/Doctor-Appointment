package com.example.doctorappointment.adaptor

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.doctorappointment.activitys.DetailsActivity
import com.example.doctorappointment.databinding.ViewholdertopdoctorBinding
import com.example.doctorappointment.domain.Doctor

class DoctorAdaptor(val context: Context, val list: List<Doctor>) : RecyclerView.Adapter<DoctorAdaptor.ViewHolder>() {
    inner class ViewHolder(val binding: ViewholdertopdoctorBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewholdertopdoctorBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.nameTxt.text = item.Name
        holder.binding.specialTxt.text = item.Special
        holder.binding.rateTxts.text = item.Rating.toString()
        holder.binding.yearTxt.text = item.Experience.toString() + " Year "

        Glide.with(holder.itemView.context)
            .load(item.Picture)
            .apply { RequestOptions().transform(CenterCrop()) }
            .into(holder.binding.img)

        holder.itemView.setOnClickListener {
            val intent = Intent(context , DetailsActivity::class.java)
            intent.putExtra("Object" , item)
            context.startActivity(intent)
        }



    }
}