package com.eugcapt.mvvm_workout.domain.repository

import com.eugcapt.mvvm_workout.domain.models.SaveUserNameParam
import com.eugcapt.mvvm_workout.domain.models.UserName

interface UserRepository {
    fun saveName(saveparam: SaveUserNameParam): Boolean

    fun getName(): UserName
}