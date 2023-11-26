package com.aviral.quickies.api.repository

import com.aviral.quickies.api.remote.MessageApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.await

class MessageApiImplementation(
    private val api: MessageApi
) {

    fun getAnswers(userMessage: String, result: (String) -> Unit) {

        CoroutineScope(Dispatchers.IO).launch {
            val answers = api.getAnswers(
                message = userMessage
            )

            withContext(Dispatchers.Main) {
                result(answers.cnt)
            }
        }

    }

}