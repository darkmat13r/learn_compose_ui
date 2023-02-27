package com.drawgestures.learncomposeui.di

import com.drawgestures.learncomposeui.ui.viewmodels.SharedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel {
        SharedViewModel(get())
    }
}