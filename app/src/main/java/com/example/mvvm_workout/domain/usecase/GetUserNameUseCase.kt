package com.example.mvvm_workout.domain.usecase

import com.example.mvvm_workout.domain.models.Username

class GetUserNameUseCase {
    fun execute(): Username {
        return Username(firstName = "Eugeny", lastName = "Here")
    }
}