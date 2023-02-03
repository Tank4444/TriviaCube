package ru.itcube.triviacube.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.itcube.triviacube.navigation.Screens


@Composable
fun HelloScreen(
    navController: NavController
){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            navController.navigate(Screens.Construction.route)
        }) {
            Text(text = "Создать викторину")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HelloScreenPreview(){

    HelloScreen(rememberNavController())
}