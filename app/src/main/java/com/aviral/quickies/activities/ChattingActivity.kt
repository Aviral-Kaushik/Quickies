package com.aviral.quickies.activities

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aviral.quickies.R
import com.aviral.quickies.adapter.ChatAdapter
import com.aviral.quickies.databinding.ActivityChattingBinding
import com.aviral.quickies.utils.DialogUtils


class ChattingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChattingBinding

    private lateinit var chatAdapter: ChatAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChattingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupChatAdapter()

        binding.chatToolbar.icBack.setOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
        }

        binding.chatToolbar.icInfo.setOnClickListener {
            DialogUtils.showInfoDialog(applicationContext)
        }

        binding.btnNext.setOnClickListener { }

        var isWelcomeImageVisible = true

        binding.messageEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (isWelcomeImageVisible) {

                    wipeWelcomeImage()

                    isWelcomeImageVisible = false

                }

            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    private fun wipeWelcomeImage() {
        val wipeAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.wipe_animation)

        val viewToRemove = binding.welcomeImage

        viewToRemove.startAnimation(wipeAnimation)

        wipeAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {

            }

            override fun onAnimationEnd(animation: Animation) {
                // Animation ended, remove the view
                val parent = viewToRemove.parent as ViewGroup
                parent.removeView(viewToRemove)
            }

            override fun onAnimationRepeat(animation: Animation) {

            }
        })

    }

    private fun rotateWelcomeImage() {
        val rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotatory_animation)

        val viewToRemove = binding.welcomeImage

        viewToRemove.startAnimation(rotateAnimation)

        rotateAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {

            }

            override fun onAnimationEnd(animation: Animation) {
                val parent = viewToRemove.parent as ViewGroup
                parent.removeView(viewToRemove)
            }

            override fun onAnimationRepeat(animation: Animation) {

            }
        })

    }

    private fun setupChatAdapter() {

        val linearLayoutManager = LinearLayoutManager(this)

        chatAdapter = ChatAdapter(this, emptyList())

        binding.messageRecyclerView.layoutManager = linearLayoutManager
        binding.messageRecyclerView.adapter = chatAdapter
    }
}