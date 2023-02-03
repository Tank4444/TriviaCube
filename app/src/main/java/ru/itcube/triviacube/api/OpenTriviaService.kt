package ru.itcube.triviacube.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.itcube.triviacube.model.OpenTriviaResponse

interface OpenTriviaService {

    //@GET("api.php?amount=10&category=9&difficulty=easy&type=boolean")
    @GET("api.php")
    fun getQuestions(
        @Query("amount") amount:Int,
        @Query("category") category:Int,
        @Query("difficulty") difficulty:String,
        @Query("type") type:String
    ):Call<OpenTriviaResponse>
}