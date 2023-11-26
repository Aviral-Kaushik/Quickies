package com.aviral.quickies.di

import com.aviral.quickies.api.remote.MessageApi
import com.aviral.quickies.api.repository.MessageApiImplementation
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppModule {

    val messageApi : MessageApi

    val messageRepository : MessageApiImplementation

}
class AppModuleImplementation : AppModule {

    override val messageApi: MessageApi by lazy {

        Retrofit.Builder()
            .baseUrl("http://api.brainshop.ai/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MessageApi::class.java)

    }

    override val messageRepository: MessageApiImplementation by lazy {

        MessageApiImplementation(messageApi)

    }

}