package com.dhikafruit.myrecyclerview

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import android.util.Log;

class DetailActivity :AppCompatActivity() {
    companion object {
        const val KEY_FRUIT = "key_fruit" // Mendefinisikan key_fruit di sini
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataFruit = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(KEY_FRUIT, Fruit::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(KEY_FRUIT)
        }

        if (dataFruit != null) {
            // Bind data ke view
            val tvDetailName = findViewById<TextView>(R.id.tv_detail_name)
            val tvDetailDescription = findViewById<TextView>(R.id.tv_detail_description)
            val tvDetailPhoto = findViewById<ImageView>(R.id.tv_detail_photo)
            tvDetailName.text = dataFruit.name
            tvDetailDescription.text = dataFruit.description
            tvDetailPhoto.setImageResource(dataFruit.photo)
        } else {
            // Handle jika data null
            Log.e("DetailActivity", "Data Fruit tidak ditemukan")
        }
    }
}