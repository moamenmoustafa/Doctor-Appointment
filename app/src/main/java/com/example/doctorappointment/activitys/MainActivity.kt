package com.example.doctorappointment.activitys

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doctorappointment.R
import com.example.doctorappointment.adaptor.CategoryAdaptor
import com.example.doctorappointment.adaptor.DoctorAdaptor
import com.example.doctorappointment.databinding.ActivityMainBinding
import com.example.doctorappointment.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        intitView()
        intitDoctor()
    }
    fun intitView(){
        binding.categoryLoader.visibility = View.VISIBLE
        viewModel.categories.observe(this , Observer {
            binding.rvViewCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL , false)
            binding.rvViewCategory.adapter = CategoryAdaptor(context = this , it)
            binding.categoryLoader.visibility = View.GONE
        })
        viewModel.fetchCategories()
    }

    fun intitDoctor(){
        binding.topDoctorLoader.visibility = View.VISIBLE
        viewModel.doctors.observe(this ,Observer{
            binding.rvViewTopDoc.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL , false)
            binding.rvViewTopDoc.adapter = DoctorAdaptor(context = this , it)
            binding.topDoctorLoader.visibility = View.GONE
        })
        viewModel.fetchDoctors()
        binding.seeAllDetails.setOnClickListener {
            startActivity(Intent(this , TopDoctorActivity::class.java))
        }
    }
}