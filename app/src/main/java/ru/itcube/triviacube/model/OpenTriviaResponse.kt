package ru.itcube.triviacube.model


import com.google.gson.annotations.SerializedName

data class OpenTriviaResponse(
    @SerializedName("response_code")
    val responseCode: Int,
    @SerializedName("results")
    val questions: List<Question>
)