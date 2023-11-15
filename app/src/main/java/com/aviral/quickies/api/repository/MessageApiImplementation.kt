package com.aviral.quickies.api.repository

import com.aviral.quickies.api.remote.MessageApi
import com.aviral.quickies.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.await

class MessageApiImplementation(
    private val api: MessageApi
) {

    fun getAnswers(userMessage: String, result: (String) -> Unit) {

        CoroutineScope(Dispatchers.IO).launch {
            val answers = api.getAnswers(
                Constants.BID,
                Constants.KEY,
                Constants.UID,
                userMessage
            ).await()

            withContext(Dispatchers.Main) {
                result(answers[0])
            }
        }

    }

}