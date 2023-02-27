package com.drawgestures.learncomposeui.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drawgestures.learncomposeui.data.models.ToDoTask
import com.drawgestures.learncomposeui.data.repository.ToDoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class SharedViewModel(private val toDoRepository: ToDoRepository) : ViewModel() {
    private val _allTasks = MutableStateFlow<List<ToDoTask>>(emptyList())
    val allTasks : StateFlow<List<ToDoTask>> = _allTasks

    fun getAllTasks(){
        viewModelScope.launch {
            toDoRepository.getAllTasks.collect{
                _allTasks.value = it
            }
        }
    }
}