package ru.itcube.triviacube.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.itcube.triviacube.screen.*

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.Hello.route ){
        composable(route = Screens.Hello.route){
            HelloScreen(navController)
        }
        composable(route = Screens.Construction.route){
            ConstructionScreen(navController)
        }
        composable(route = Screens.Quiz.route){
            QuizScreen(navController)
        }
    }
}



