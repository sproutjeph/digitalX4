package com.example.digitalx4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.digitalx4.ui.navigation.ServiceReportNavigation
import com.example.digitalx4.ui.screens.HomeScreen
import com.example.digitalx4.ui.theme.DigitalX4Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
           ServiceReportNavigation()
            }
        }
    }
}

@Composable
fun MyApp(content:@Composable ()-> Unit) {
    DigitalX4Theme {
      content()
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DigitalX4Theme {
    }
}