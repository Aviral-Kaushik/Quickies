package com.aviral.quickies.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aviral.quickies.application.QuickiesApplication
import com.aviral.quickies.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    /**
     * TODO 1.] Get BID, API KEY and UID from brainshop.ai website and it to constants object.
     *      2.] paste the below code snippet for the API Call
     *      3.] Update the API models accordingly to dummy data from the server accordingly to ChatGPT.
     *      3.] Complete the Code for Adapter.
     *      3.] Completed the UI accordingly
     * */

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO This is the code snippet for getting result from api
        QuickiesApplication.appModule.messageRepository.getAnswers(
            "Tell me a jock"
        ) {
//            notifyDataSetChanged()
        }

    }
}