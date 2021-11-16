package com.clemen.pac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.clemen.pac.databinding.Activity4Binding


class Activity4 : AppCompatActivity() {
    private lateinit var binding: Activity4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button4Main.setOnClickListener {
            finish()
        }
    }
}