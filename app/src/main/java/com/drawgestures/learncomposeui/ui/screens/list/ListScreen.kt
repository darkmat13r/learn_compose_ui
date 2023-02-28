package com.drawgestures.learncomposeui.ui.screens.list

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.drawgestures.learncomposeui.R
import com.drawgestures.learncomposeui.ui.viewmodels.SharedViewModel
import com.drawgestures.learncomposeui.util.SearchAppBarState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    sharedViewModel: SharedViewModel,
    navigateToTaskScreen: (Int) -> Unit
) {
    LaunchedEffect(key1 = true){
        Log.d("ListScreen", "LaunchEffect Triggered!")
        sharedViewModel.getAllTasks()
    }
    val allTasks by sharedViewModel.allTasks.collectAsState()
    allTasks.forEach {
        Log.d("ListScreen", "${it.title}")
    }
    val searchAppBarState: SearchAppBarState by sharedViewModel.searchAppBarState
    val searchTextState: String by sharedViewModel.searchTextState
    Scaffold(
        topBar = {
            ListAppBar(
                searchAppBarState = searchAppBarState,
                sharedViewModel = sharedViewModel,
                searchTextState = searchTextState
            )
        },
        floatingActionButton = {
            ListFab(navigateToTaskScreen)
        }
    ) { contentPadding ->
        // Screen content
        Box(modifier = Modifier.padding(contentPadding)) {
            ListContent(allTasks, navigateToTaskScreen)
        }
    }
}

@Composable
fun ListFab(
    navigateToTaskScreen: (Int) -> Unit
) {
    FloatingActionButton(onClick = {
        navigateToTaskScreen(-1)
    }) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_button)
        )
    }
}

@Composable
@Preview
private fun ListScreenPreview() {
    //ListScreen(sharedViewModel = SharedViewModel(get()), navigateToTaskScreen = {})
}