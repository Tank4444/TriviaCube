package ru.itcube.triviacube.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun constructionScreen(navController: NavController){
    Text(text = "Construction screen")
}


@Composable
@Preview(showBackground = true)
fun constractionScreenPreview(){
    constructionScreen(rememberNavController())
}

