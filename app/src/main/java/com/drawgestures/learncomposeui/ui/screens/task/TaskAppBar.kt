package com.drawgestures.learncomposeui.ui.screens.task

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.drawgestures.learncomposeui.util.Action

@Composable
fun TaskAppBar( navigateToListScreen : (Action) -> Unit){
    NewTaskAppBar(navigateToListScreen = navigateToListScreen)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTaskAppBar(
    navigateToListScreen : (Action) -> Unit
){
    TopAppBar(
        navigationIcon = {
            BackAction(onBackClicked = navigateToListScreen)
        },
        title = {
            Text(text = "Add Task", color = MaterialTheme.colorScheme.onBackground)
        },
        actions = {
            AddAction(onAddClicked = navigateToListScreen)
        }
    )
}

@Composable
fun BackAction(onBackClicked : (Action) -> Unit){
    IconButton(onClick = {onBackClicked(Action.NO_ACTION)}){
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back button")
    }
}

@Composable
fun AddAction(onAddClicked : (Action) -> Unit){
    IconButton(onClick = {onAddClicked(Action.ADD)}){
        Icon(imageVector = Icons.Filled.Check, contentDescription = "Back button")
    }
}


@Composable
@Preview
fun NewTaskAppBarPreview(){
    NewTaskAppBar(navigateToListScreen = {})
}