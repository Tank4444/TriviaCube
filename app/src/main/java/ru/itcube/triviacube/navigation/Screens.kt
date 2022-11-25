package ru.itcube.triviacube.navigation

sealed class Screens(val route:String){
    object Hello: Screens("hello")
    object Construction: Screens("construction")
    object Quiz: Screens("quiz")
}