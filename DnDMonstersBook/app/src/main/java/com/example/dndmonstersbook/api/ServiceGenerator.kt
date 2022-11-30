package com.example.dndmonstersbook.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceGenerator {
    companion object {

        fun getRetrofitInstance(path : String) : Retrofit {
            val client = OkHttpClient.Builder().build()
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
    }
}