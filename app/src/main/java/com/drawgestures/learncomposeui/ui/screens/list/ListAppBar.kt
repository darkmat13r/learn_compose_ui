package com.drawgestures.learncomposeui.ui.screens.list

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.drawgestures.learncomposeui.components.PriorityItem
import com.drawgestures.learncomposeui.data.models.Priority
import com.drawgestures.learncomposeui.ui.theme.LARGE_PADDING
import com.drawgestures.learncomposeui.ui.theme.TOP_APP_BAR_HEIGHT

@Composable
fun ListAppBar() {
    // DefaultListAppBar(onSearchClick = {}, onSortClick = {}, onDeleteClick = {})
    SearchAppBar(text = "Search", onTextChange = {}, onCloseClicked = {}, onSearchClicked = {})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar(
    onSearchClick: () -> Unit,
    onSortClick: (Priority) -> Unit,
    onDeleteClick: () -> Unit
) {
    TopAppBar(title = {
        Text(text = "Task")
    }, actions = {
        ListAppBarActions(
            onSearchClick = onSearchClick,
            onSortClick = onSortClick,
            onDeleteClick = onDeleteClick
        )
    })
}

@Composable
fun ListAppBarActions(
    onSearchClick: () -> Unit,
    onSortClick: (Priority) -> Unit,
    onDeleteClick: () -> Unit
) {
    Row {
        SearchAction(onSearchClick)
        SortAction(onSortClick = onSortClick)
        DeleteAllAction(onDeleteClick = onDeleteClick)
    }
}

@Composable
fun SearchAction(onSearchClick: () -> Unit) {
    IconButton(onClick = { onSearchClick() }) {
        Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
    }
}

@Composable
fun SortAction(onSortClick: (Priority) -> Unit) {
    var expanded by remember {
        mutableStateOf(false)
    }
    IconButton(onClick = { expanded = !expanded }) {
        Icon(imageVector = Icons.Filled.List, contentDescription = "Sort")
        DropdownMenu(expanded = expanded, onDismissRequest = {
            expanded = false
        }) {
            DropdownMenuItem(text = { PriorityItem(priority = Priority.LOW) }, onClick = {
                onSortClick(Priority.LOW)
                expanded = false
            })
            DropdownMenuItem(text = { PriorityItem(priority = Priority.HIGH) }, onClick = {
                onSortClick(Priority.HIGH)
                expanded = false
            })
            DropdownMenuItem(text = { PriorityItem(priority = Priority.NONE) }, onClick = {
                onSortClick(Priority.NONE)
                expanded = false
            })
        }
    }
}

@Composable
fun DeleteAllAction(onDeleteClick: () -> Unit) {
    var expanded by remember {
        mutableStateOf(false)
    }
    IconButton(onClick = { expanded = !expanded }) {
        Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Sort")
        DropdownMenu(expanded = expanded, onDismissRequest = {
            expanded = false
        }) {
            DropdownMenuItem(text = {
                Text(
                    modifier = Modifier.padding(
                        start = LARGE_PADDING
                    ), text = "Delete All", style = MaterialTheme.typography.bodyMedium
                )
            }, onClick = {
                onDeleteClick()
                expanded = false
            })

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(TOP_APP_BAR_HEIGHT), color = MaterialTheme.colorScheme.primary
    ) {
        TextField(modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = onTextChange,
            placeholder = {
                Text(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    text = "Search",
                    color = Color.White
                )
            },
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    modifier = Modifier.alpha(ContentAlpha.disabled),
                    onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search Icon",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    modifier = Modifier.alpha(ContentAlpha.disabled),
                    onClick = onCloseClicked
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Close Icon",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = MaterialTheme.colorScheme.onPrimary,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = Color.Transparent
            )
        )
    }
}

@Composable
@Preview
private fun DefaultListAppBarPreview() {
    DefaultListAppBar(onSearchClick = {}, onSortClick = {}, onDeleteClick = {})
}

@Composable
@Preview
private fun SearchAppBarPreview() {
    SearchAppBar(text = "Search", onTextChange = {}, onCloseClicked = {}, onSearchClicked = {})
}