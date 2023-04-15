package com.example.digitalx4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.digitalx4.ui.navigation.Screen
import com.example.digitalx4.ui.navigation.SetupNavigation
import com.example.digitalx4.ui.theme.DigitalX4Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val widthSizeClass = calculateWindowSizeClass(this).widthSizeClass

            DigitalX4Theme {
                val navController = rememberNavController()
                SetupNavigation(
                    startDestination = getStartDestination(),
                    navController = navController,
                    widthSizeClass = widthSizeClass
                )
            }
        }
    }
}

private fun getStartDestination():String{
    return Screen.Home.route
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DigitalX4Theme {
    }
}