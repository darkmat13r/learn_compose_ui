package com.drawgestures.learncomposeui.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.drawgestures.learncomposeui.data.models.ToDoTask

@Database(entities = [ToDoTask::class], version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase(){

    abstract fun todoDao() : ToDoDao
}