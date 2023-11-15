package com.aviral.quickies.api.remote

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MessageApi {

    @GET("/get")
    suspend fun getAnswers(
        @Query("bid") bid : String,
        @Query("key") key : String,
        @Query("uid") uid : String,
        @Query("msg") message : String
    ) : Call<List<String>>

}