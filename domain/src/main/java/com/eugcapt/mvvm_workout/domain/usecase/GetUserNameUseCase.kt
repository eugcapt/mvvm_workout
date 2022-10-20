package com.eugcapt.mvvm_workout.domain.usecase

import com.eugcapt.mvvm_workout.domain.models.UserName
import com.eugcapt.mvvm_workout.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(): UserName {
        return userRepository.getName()
    }
}