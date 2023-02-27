package com.drawgestures.learncomposeui

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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.drawgestures.learncomposeui.navigation.SetupNavigation
import com.drawgestures.learncomposeui.ui.theme.LearnComposeUITheme

class MainActivity : ComponentActivity() {
    private lateinit var navController : NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeUITheme {
                // A surface container using the 'background' color from the theme
                navController = rememberNavController()
                SetupNavigation(navHostController = navController)

            }
        }
    }
}
