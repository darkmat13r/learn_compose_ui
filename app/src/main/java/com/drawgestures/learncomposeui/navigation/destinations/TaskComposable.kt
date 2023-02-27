package com.drawgestures.learncomposeui.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.drawgestures.learncomposeui.util.Action
import com.drawgestures.learncomposeui.util.Constants

fun NavGraphBuilder.taskComposable(navigateToListScreen : (Action) -> Unit){
    composable(
        route = Constants.TASK_SCREEN,
        arguments = listOf(navArgument(Constants.TASK_ARG_KEY){
            type = NavType.IntType
        }),
    ){

    }
}