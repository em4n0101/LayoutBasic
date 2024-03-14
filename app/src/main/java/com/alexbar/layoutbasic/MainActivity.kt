package com.alexbar.layoutbasic

// Android Framework

// Compose Activity

// Compose Foundation

// Compose Material3 Components

// Compose UI

// Project-Specific Imports
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.rememberNavController
import com.alexbar.layoutbasic.movies_app.nav.BottomNavigationBar
import com.alexbar.layoutbasic.movies_app.nav.BottomNavigationGraph

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            Scaffold(
                bottomBar = {
                    BottomNavigationBar(navController = navController)
                }
            ) {
                BottomNavigationGraph(navController)
            }
        }
    }
}
