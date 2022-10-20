package com.eugcapt.mvvm_workout.data.repository

import com.eugcapt.mvvm_workout.data.storage.models.User
import com.eugcapt.mvvm_workout.data.storage.UserStorage
import com.eugcapt.mvvm_workout.domain.models.SaveUserNameParam
import com.eugcapt.mvvm_workout.domain.models.UserName
import com.eugcapt.mvvm_workout.domain.repository.UserRepository

/*
private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_FIRST_NAME = "DEFAULT_FIRST_NAME"
private const val DEFAULT_LAST_NAME = "DEFAULT_LAST_NAME"

 */



 class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository {


     override fun saveName(saveparam: SaveUserNameParam): Boolean {

         val user = User(firstName = saveparam.name, lastName = "")
         return userStorage.save(user)
     }

     override fun getName(): UserName {

         val user = userStorage.get()
         return UserName(firstName = user.firstName, lastName = user.lastName)
     }

}
