package com.aviral.quickies.api.remote

import com.aviral.quickies.models.BrainResponse
import com.aviral.quickies.utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MessageApi {

    @GET("/get")
    suspend fun getAnswers(
        @Query("bid") bid : String = Constants.BID,
        @Query("key") key : String = Constants.KEY,
        @Query("uid") uid : String = Constants.UID,
        @Query("msg") message : String
    ) : Call<BrainResponse>

}