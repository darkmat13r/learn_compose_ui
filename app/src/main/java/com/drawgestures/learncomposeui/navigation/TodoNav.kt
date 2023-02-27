package com.drawgestures.learncomposeui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.drawgestures.learncomposeui.navigation.destinations.listComposable
import com.drawgestures.learncomposeui.navigation.destinations.taskComposable
import com.drawgestures.learncomposeui.util.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(navHostController: NavHostController){
  val screen = remember( navHostController){
      Screens(navController = navHostController)
  }
    NavHost(navController = navHostController, startDestination = LIST_SCREEN){
        listComposable(
            navigateToTaskScreen = screen.task
        )
        taskComposable(
            navigateToListScreen = screen.list
        )
    }
}