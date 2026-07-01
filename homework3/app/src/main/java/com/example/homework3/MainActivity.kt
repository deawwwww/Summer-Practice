package com.example.homework3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.homework3.data.GameModel
import com.example.homework3.navigation.ListScreen
import com.example.homework3.navigation.MainScreen
import com.example.homework3.ui.screens.MainScreen
import com.example.homework3.ui.screens.SecondScreen
import com.example.homework3.ui.theme.Homework3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Homework3Theme {
                val navController = rememberNavController()
                val objectsList = remember { mutableStateListOf<GameModel>() }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = MainScreen,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable<MainScreen> {
                            MainScreen(
                                objectsList = objectsList,
                                onNavigateToList = { navController.navigate(ListScreen) }
                            )
                        }

                        composable<ListScreen> {
                            SecondScreen(games = objectsList)
                        }
                    }
                }
            }
        }
    }
}