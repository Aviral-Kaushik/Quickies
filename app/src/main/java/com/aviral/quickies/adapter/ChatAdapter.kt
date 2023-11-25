package com.aviral.quickies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aviral.quickies.databinding.LayoutItemBotMessageBinding
import com.aviral.quickies.databinding.LayoutItemUserMessageBinding
import com.aviral.quickies.models.Message

class ChatAdapter(
    private val messages: List<Message>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val userMessageType = 1
    private val botMessageType = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when(viewType) {

            botMessageType -> {
                val binding = LayoutItemBotMessageBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )

                BotMessageViewHolder(binding)
            }
            else -> {
                val binding = LayoutItemUserMessageBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )

                UserMessageViewHolder(binding)
            }

        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder.itemViewType) {

            botMessageType -> {

                val botViewHolder = holder as BotMessageViewHolder

                botViewHolder.botMessage.text = messages[position].message

            }

            else -> {

                val userViewHolder = holder as UserMessageViewHolder

                userViewHolder.userMessage.text = messages[position].message

            }

        }

    }

    override fun getItemViewType(position: Int): Int {

        return if (messages[position].messageType == "Bot Message") {
            botMessageType
        } else {
            userMessageType
        }

    }

    override fun getItemCount(): Int {
        return messages.size
    }

    inner class UserMessageViewHolder(binding: LayoutItemUserMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val userMessage = binding.tvUserMessage

    }

    inner class BotMessageViewHolder(binding: LayoutItemBotMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val botMessage = binding.tvBotMessage

    }
}