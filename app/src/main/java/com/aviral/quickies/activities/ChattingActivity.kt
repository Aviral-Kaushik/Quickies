package com.aviral.quickies.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aviral.quickies.R
import com.aviral.quickies.databinding.ActivityChattingBinding

class ChattingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChattingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChattingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.chatToolbar.icBack.setOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
        }

        binding.btnNext.setOnClickListener {  }
    }
}