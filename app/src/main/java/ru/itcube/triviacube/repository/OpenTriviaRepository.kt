package ru.itcube.triviacube.repository

import retrofit2.Call
import retrofit2.Response
import ru.itcube.triviacube.api.RetrofitInstance
import ru.itcube.triviacube.model.OpenTriviaResponse

class OpenTriviaRepository {
    fun getQuiescence(
        amount: Int,
        category: String,
        difficulty: String,
        type: String
    ): Call<OpenTriviaResponse> {
        return RetrofitInstance.openTriviaService.getQuestions(
            amount = amount,
            category = when (category) {
                "General Knowledge" -> "9"
                "Entertainment: Books" -> "10"
                "Entertainment: Film" -> "11"
                "Entertainment: Music" -> "12"
                "Entertainment: Musicals & Theatres" -> "13"
                "Entertainment: Television" -> "14"
                "Entertainment: Video Games" -> "15"
                "Entertainment: Board Games" -> "16"
                "Science & Nature" -> "17"
                "Science: Computers" -> "18"
                "Science: Mathematics" -> "19"
                "Mythology" -> "20"
                "Sports" -> "21"
                "Geography" -> "22"
                "History" -> "23"
                "Politics" -> "24"
                "Art" -> "25"
                "Celebrities"  -> "26"
                "Animals" -> "27"
                else -> ""
            },
            difficulty = difficulty,
            type = if(type.equals("any Type")) "" else type
        )
    }
}