package com.drawgestures.learncomposeui.ui.screens.list

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.drawgestures.learncomposeui.data.models.Priority
import com.drawgestures.learncomposeui.data.models.ToDoTask
import com.drawgestures.learncomposeui.ui.theme.LARGE_PADDING
import com.drawgestures.learncomposeui.ui.theme.PRIORITY_INDICATOR_SIZE
import com.drawgestures.learncomposeui.ui.theme.TASK_ITEM_ELEVATION
import com.drawgestures.learncomposeui.util.RequestState

@Composable
fun ListContent(tasks: RequestState<List<ToDoTask>>, navigateToTaskScreen: (taskId: Int) -> Unit) {
    if(tasks is RequestState.Success){
        if(tasks.data.isEmpty()){
            EmptyContent()
        }else{
            DisplayTasks(tasks = tasks.data, navigateToTaskScreen = navigateToTaskScreen)
        }
    }else if(tasks is RequestState.Error){

    }else if(tasks is RequestState.Loading){
        CircularProgressIndicator()
    }
}

@Composable
fun DisplayTasks(tasks: List<ToDoTask>, navigateToTaskScreen: (taskId: Int) -> Unit){
    LazyColumn{
        items(count = tasks.size, itemContent = {
            TaskItem(todoTask = tasks[it], navigateToTaskScreen = navigateToTaskScreen)
        })
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TaskItem(
    todoTask: ToDoTask,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.primaryContainer,
        shape = RectangleShape,
        elevation = TASK_ITEM_ELEVATION,
        onClick = {
            navigateToTaskScreen(todoTask.id)
        }
    ) {
        Column(
            modifier = Modifier
                .padding(LARGE_PADDING)
                .fillMaxWidth()
        ) {
            Row {
                Text(
                    modifier = Modifier.weight(1f),
                    text = todoTask.title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Box(modifier = Modifier.wrapContentSize(), contentAlignment = Alignment.TopEnd) {
                    Canvas(
                        modifier = Modifier
                            .width(PRIORITY_INDICATOR_SIZE)
                            .height(
                                PRIORITY_INDICATOR_SIZE
                            ), onDraw = {
                            drawCircle(color = todoTask.priority.color)
                        }
                    )
                }
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = todoTask.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
@Preview
fun TaskItemPreview() {
    TaskItem(
        todoTask = ToDoTask(0, "Title", "Some ramdom text", Priority.MEDIUM),
        navigateToTaskScreen = {}
    )
}