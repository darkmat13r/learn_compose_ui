package com.drawgestures.learncomposeui.ui.screens.task

import android.annotation.SuppressLint
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.drawgestures.learncomposeui.ui.viewmodels.SharedViewModel
import com.drawgestures.learncomposeui.util.Action

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskScreen(
    taskId: Int,
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    Scaffold(
        topBar = {
            TaskAppBar(navigateToListScreen = navigateToListScreen)
        },
        content = {
            Text("Test")
        })
}