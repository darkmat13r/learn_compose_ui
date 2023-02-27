package com.drawgestures.learncomposeui

import android.app.Application
import com.drawgestures.learncomposeui.di.databaseModule
import com.drawgestures.learncomposeui.di.repositoryModule
import com.drawgestures.learncomposeui.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ToDoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ToDoApplication)
            modules(
                databaseModule,
                repositoryModule,
                viewModelModules
            )
        }
    }
}