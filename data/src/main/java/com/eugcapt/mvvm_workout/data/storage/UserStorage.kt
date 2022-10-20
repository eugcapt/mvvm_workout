package com.eugcapt.mvvm_workout.data.storage

import com.eugcapt.mvvm_workout.data.storage.models.User

interface UserStorage {
    fun save(user: User): Boolean

    fun get(): User
}