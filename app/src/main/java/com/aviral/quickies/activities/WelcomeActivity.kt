package com.aviral.quickies.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aviral.quickies.application.QuickiesApplication
import com.aviral.quickies.databinding.ActivityWelcomeBinding
import com.aviral.quickies.di.AppModule
import com.aviral.quickies.di.AppModuleImplementation

class WelcomeActivity : AppCompatActivity() {

    /**
     * TODO 1.] Get BID, API KEY and UID from brainshop website and it to constants onject.
     *      2.] paste the below code snippet for the API Call
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