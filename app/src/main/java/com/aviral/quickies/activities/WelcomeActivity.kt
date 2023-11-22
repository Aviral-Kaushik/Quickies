package com.aviral.quickies.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aviral.quickies.application.QuickiesApplication
import com.aviral.quickies.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    /**
     * TODO 1.] paste the below code snippet for the API Call
     *      2.] Complete the Code for Adapter.
     *      3.] Completed the UI accordingly
     * */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetStarted.setOnClickListener {
            startActivity(Intent(this, ChattingActivity::class.java))
        }

        // TODO This is the code snippet for getting result from api
        QuickiesApplication.appModule.messageRepository.getAnswers(
            "Tell me a jock"
        ) {
//            notifyDataSetChanged()
        }

    }
}