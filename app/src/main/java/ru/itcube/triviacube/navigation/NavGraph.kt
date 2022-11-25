package ru.itcube.triviacube.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.itcube.triviacube.screen.constructionScreen
import ru.itcube.triviacube.screen.helloScreen
import ru.itcube.triviacube.screen.quizScreen

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.Hello.route ){
        composable(route = Screens.Hello.route){
            helloScreen(navController)
        }
        composable(route = Screens.Construction.route){
            constructionScreen(navController)
        }
        composable(route = Screens.Quiz.route){
            quizScreen(navController)
        }
    }
}



