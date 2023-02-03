package ru.itcube.triviacube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import ru.itcube.triviacube.navigation.NavGraph
import ru.itcube.triviacube.ui.theme.TriviaCubeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriviaCubeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    screen()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TriviaCubeTheme {
        screen()
    }
}

@Composable
fun screen(){
    Scaffold (
        topBar = {TopAppBar(
            title = {Text(text = "Hello")},
            modifier = Modifier,
            )
        },
        content = {


            val navController = rememberNavController()
            NavGraph(navController = navController)
        }
    )
}