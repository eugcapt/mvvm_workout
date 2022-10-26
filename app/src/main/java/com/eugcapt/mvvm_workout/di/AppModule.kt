package com.eugcapt.mvvm_workout.di

import com.eugcapt.mvvm_workout.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module{
    viewModel<MainViewModel>{
        MainViewModel(getUserNameUseCase = get(),
                      saveUserNameUseCase = get()
        )
    }
}