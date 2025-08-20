package com.example.doctorappointment.activitys

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.doctorappointment.databinding.ActivityIntroBinding

class introActivity : BaseActivity() {
    lateinit var  binding : ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            startBtn.setOnClickListener{
                val intent = Intent(this@introActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}