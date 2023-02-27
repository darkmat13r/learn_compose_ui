package com.drawgestures.learncomposeui.di

import com.drawgestures.learncomposeui.data.repository.ToDoRepository
import org.koin.dsl.module

val repositoryModule= module {
    single {
        ToDoRepository(get())
    }
}