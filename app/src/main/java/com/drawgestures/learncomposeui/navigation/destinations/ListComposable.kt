package com.drawgestures.learncomposeui.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.drawgestures.learncomposeui.ui.screens.list.ListScreen
import com.drawgestures.learncomposeui.util.Constants.LIST_ARG_KEY
import com.drawgestures.learncomposeui.util.Constants.LIST_SCREEN


fun NavGraphBuilder.listComposable(navigateToTaskScreen : (Int) -> Unit){
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARG_KEY){
            type = NavType.StringType
        }),
    ){
        ListScreen(navigateToTaskScreen = navigateToTaskScreen)
    }
}