package com.eugcapt.mvvm_workout.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eugcapt.mvvm_workout.data.repository.UserRepositoryImpl
import com.eugcapt.mvvm_workout.data.storage.sharedprefs.SharedPrefsUserStorage

class MainViewModelFactory(context: Context): ViewModelProvider.Factory {

        private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = SharedPrefsUserStorage(context = context))
    }

    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE){
        com.eugcapt.mvvm_workout.domain.usecase.GetUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE){
        com.eugcapt.mvvm_workout.domain.usecase.SaveUserNameUseCase(
            userRepository = userRepository
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase = getUserNameUseCase,
                             saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }
}