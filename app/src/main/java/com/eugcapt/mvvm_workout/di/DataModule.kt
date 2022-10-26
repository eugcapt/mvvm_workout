package com.eugcapt.mvvm_workout.di


import com.eugcapt.mvvm_workout.data.repository.UserRepositoryImpl
import com.eugcapt.mvvm_workout.data.storage.UserStorage
import com.eugcapt.mvvm_workout.data.storage.sharedprefs.SharedPrefsUserStorage
import com.eugcapt.mvvm_workout.domain.repository.UserRepository
import org.koin.dsl.module


val dataModule = module {
 single<UserStorage>  {
     SharedPrefsUserStorage(context = get())
 }
    single<UserRepository>  {
        UserRepositoryImpl(userStorage = get())
    }
}