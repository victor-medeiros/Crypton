package com.victor.crypton.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.victor.crypton.ui.theme.CryptonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptonTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    CryptonTheme {
        NavGraph(navController = navController)
    }
}