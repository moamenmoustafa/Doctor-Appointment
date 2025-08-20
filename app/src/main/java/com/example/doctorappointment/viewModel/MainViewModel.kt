package com.example.doctorappointment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.doctorappointment.domain.Category
import com.example.doctorappointment.domain.Doctor
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainViewModel : ViewModel() {
    private val firebaseDatabase = FirebaseDatabase.getInstance()
    private val _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>> = _categories

    private val _doctor = MutableLiveData<List<Doctor>>()
    val doctors: LiveData<List<Doctor>> = _doctor

    fun fetchCategories() {
        val Ref = firebaseDatabase.getReference("Category")
        Ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
               val lists = mutableListOf<Category>()
                for (childSnapShot in snapshot.children){
                    val list = childSnapShot.getValue(Category::class.java)
                    if (list != null){
                        lists.add(list)
                    }
                }
                _categories.value = lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
    }

    fun fetchDoctors() {
        val Ref = firebaseDatabase.getReference("Doctors")
        Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<Doctor>()
                for (childSnapShot in snapshot.children) {
                    val list = childSnapShot.getValue(Doctor::class.java)
                    if (list != null) {
                        lists.add(list)
                    }
                }
                _doctor.value = lists
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }


}