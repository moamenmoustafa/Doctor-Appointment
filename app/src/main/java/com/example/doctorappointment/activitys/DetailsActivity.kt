package com.example.doctorappointment.activitys

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

import com.example.doctorappointment.R
import com.example.doctorappointment.databinding.ActivityDetailsBinding
import com.example.doctorappointment.domain.Doctor

class DetailsActivity : AppCompatActivity() {
    lateinit var binding : ActivityDetailsBinding
    lateinit var item : Doctor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
    }
    fun getData() {
        item = intent.getParcelableExtra("Object")!!
        binding.apply {
            titleTexts.text = item.Name
            specialText.text = item.Special
            addressText.text = item.Address
            patiensText.text = item.Patiens
            experinceText.text = item.Experience.toString() + "Years"
            rateText.text = "${item.Rating}"
            bidText.text = item.Biography

            backbtn.setOnClickListener {
                finish()
            }

            website.setOnClickListener {
                var i = Intent(Intent.ACTION_VIEW)
                i.setData(Uri.parse(item.Site))
                startActivity(i)
            }
            message.setOnClickListener {
                var uri = Uri.parse("smsto: ${item.Mobile}")
                var i = Intent(Intent.ACTION_SENDTO , uri)
                i.putExtra("sms body" , "The Sms Text")
                startActivity(i)
            }
            call.setOnClickListener {
                var uri = "tel:${item.Mobile}"
                var i = Intent(Intent.ACTION_DIAL , Uri.parse(uri))
                startActivity(i)
            }

            direction.setOnClickListener {
                val i = Intent(Intent.ACTION_VIEW , Uri.parse(item.Location))
                startActivity(i)
            }
            share.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.setType("text/plain")
                intent.putExtra(Intent.EXTRA_SUBJECT , item.Name)
                intent.putExtra(Intent.EXTRA_TEXT , item.Name + " " + item.Mobile + " " + item.Address )
                startActivity(intent)
            }
            Glide.with(this@DetailsActivity)
                .load(item.Picture)
                .into(imgdoc)







        }
    }
}