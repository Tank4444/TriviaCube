package ru.itcube.triviacube.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://opentdb.com/")
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }

    val openTriviaService: OpenTriviaService by lazy {
        retrofit.create(OpenTriviaService::class.java)
    }
}