package ru.itcube.triviacube.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import retrofit2.Callback
import retrofit2.Response
import ru.itcube.triviacube.component.SingleChoiceList
import ru.itcube.triviacube.model.OpenTriviaResponse
import ru.itcube.triviacube.repository.OpenTriviaRepository

@Composable
fun ConstructionScreen(navController: NavController){
    val openTriviaRepository= OpenTriviaRepository()
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Amount",
            modifier = Modifier.padding(10.dp),
            fontSize = 30.sp
        )
        val amount = remember {
            mutableStateOf(TextFieldValue("10"))
        }
        TextField(
            value = amount.value,
            onValueChange = {
                amount.value = it
            },
            label = { Text("label") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Text(
            text = "Category",
            modifier = Modifier.padding(10.dp),
            fontSize = 30.sp
        )
        val category = remember {
            mutableStateOf("Any Category")
        }
        SingleChoiceList(
            list = listOf(
                "Any Category",
                "General Knowledge",
                "Entertainment: Books",
                "Entertainment: Film",
                "Entertainment: Music",
                "Entertainment: Musicals & Theatres",
                "Entertainment: Television",
                "Entertainment: Video Games",
                "Entertainment: Board Games",
                "Science & Nature",
                "Science: Computers",
                "Science: Mathematics",
                "Mythology",
                "Sports",
                "Geography",
                "History",
                "Politics",
                "Art",
                "Celebrities",
                "Animals",
            ),
            selectedId = 0,
            onSelected = {
                category.value = it
            }
        )
        Text(
            text = "Difficulty",
            modifier = Modifier.padding(10.dp),
            fontSize = 30.sp)

        val difficulty = remember {
            mutableStateOf("easy")
        }
        SingleChoiceList(
            list = listOf(
                "easy",
                "medium",
                "hard"
        ),
            selectedId =0,
            onSelected ={
                difficulty.value = it
            } )
        Text(
            text = "Type",
            modifier = Modifier.padding(10.dp),
            fontSize = 30.sp)
        val type = remember {
            mutableStateOf("any type")
        }
        SingleChoiceList(
            list = listOf(
                "any Type",
                "multiple",
                "boolean"),
            selectedId = 0,
            onSelected = {
                type.value = it
            })
        val result = remember {
            mutableStateOf("")
        }
        Text(text = result.value)
        Button(onClick = {
            openTriviaRepository.getQuiescence(
                amount = amount.value.text.toInt(),
                category = category.value,
                difficulty = difficulty.value,
                type = type.value
            ).enqueue(object : Callback<OpenTriviaResponse> {
                override fun onResponse(
                    call: retrofit2.Call<OpenTriviaResponse>,
                    response: Response<OpenTriviaResponse>
                ) {
                    result.value = response.body().toString()
                }

                override fun onFailure(call: retrofit2.Call<OpenTriviaResponse>, t: Throwable) {
                    result.value = "Error"
                }


            })

        }) {
            Text(text = "Request")
        }
    }

}


@Composable
@Preview(showBackground = true)
fun ConstractionScreenPreview(){
    ConstructionScreen(rememberNavController())
}

