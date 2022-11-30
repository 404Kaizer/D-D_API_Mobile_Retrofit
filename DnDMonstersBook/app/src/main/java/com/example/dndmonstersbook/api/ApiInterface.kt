package com.example.dndmonstersbook.api

import com.example.dndmonstersbook.model.MonstersResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET(ApiConstants.END_POINTS)
    fun getMonsters() : Call<MonstersResponse>
}