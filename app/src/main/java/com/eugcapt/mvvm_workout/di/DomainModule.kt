package com.eugcapt.mvvm_workout.di

import com.eugcapt.mvvm_workout.domain.usecase.GetUserNameUseCase
import com.eugcapt.mvvm_workout.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetUserNameUseCase>{
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase>{
        SaveUserNameUseCase(userRepository = get())
    }
}