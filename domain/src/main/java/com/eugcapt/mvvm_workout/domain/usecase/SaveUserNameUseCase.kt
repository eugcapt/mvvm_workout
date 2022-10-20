package com.eugcapt.mvvm_workout.domain.usecase

import com.eugcapt.mvvm_workout.domain.models.SaveUserNameParam
import com.eugcapt.mvvm_workout.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParam): Boolean {

        val oldUserName = userRepository.getName()

        if (oldUserName.firstName == param.name) return true

        return userRepository.saveName(saveparam = param)
    }
}