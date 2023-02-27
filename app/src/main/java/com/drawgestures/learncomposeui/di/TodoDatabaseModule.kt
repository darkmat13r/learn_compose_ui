package com.drawgestures.learncomposeui.di

import androidx.room.Room
import com.drawgestures.learncomposeui.data.ToDoDao
import com.drawgestures.learncomposeui.data.ToDoDatabase
import com.drawgestures.learncomposeui.util.Constants
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<ToDoDatabase> {
        Room.databaseBuilder(androidContext(), ToDoDatabase::class.java, Constants.DATABASE_NAME)
            .build()
    }

    single<ToDoDao> {
        get<ToDoDatabase>().todoDao()
    }
}