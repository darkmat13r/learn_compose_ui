package com.drawgestures.learncomposeui.data.repository

import com.drawgestures.learncomposeui.data.ToDoDao
import com.drawgestures.learncomposeui.data.models.ToDoTask
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ToDoRepository (private val toDoDao: ToDoDao){
    val getAllTasks : Flow<List<ToDoTask>> = toDoDao.getAllTasks()
    val sortByLowPriority : Flow<List<ToDoTask>> = toDoDao.sortByLowPriority()
    val sortByHighPriority : Flow<List<ToDoTask>> = toDoDao.sortByHighPriority()

    fun getSelectedTask(taskId : Long) : Flow<ToDoTask>{
        return toDoDao.getById(taskId)
    }

    fun search(query : String) : Flow<List<ToDoTask>>{
        return toDoDao.search(query)
    }

    suspend fun addTask(toDoTask: ToDoTask){
        toDoDao.create(toDoTask)
    }

    suspend fun updateTask(toDoTask: ToDoTask){
        toDoDao.update(toDoTask)
    }

    suspend fun deleteTask(toDoTask: ToDoTask){
        toDoDao.delete(toDoTask)
    }

    suspend fun deleteAllTask(){
        toDoDao.deleteAll()
    }
}