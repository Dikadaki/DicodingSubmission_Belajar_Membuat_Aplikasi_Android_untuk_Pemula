package com.dhikafruit.myrecyclerview

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_me)

        val tvMyName: TextView = findViewById(R.id.tv_my_name)
        val tvMyEmail: TextView = findViewById(R.id.tv_my_email)
        val myPhoto: ImageView = findViewById(R.id.tv_my_photo)
        // Set nama dan email
        tvMyName.text = getString(R.string.my_name)
        tvMyEmail.text = getString(R.string.my_email)
        myPhoto.setImageResource(R.drawable.pas_foto_dhika)
    }
}
