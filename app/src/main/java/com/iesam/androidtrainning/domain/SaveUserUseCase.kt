package com.iesam.androidtrainning.domain

import com.iesam.androidtrainning.app.ErrorApp
import com.iesam.kotlintrainning.Either

class SaveUserUseCase (private val repository: UserRepository){

    operator fun invoke (user : User) : Either<ErrorApp, Boolean> {
        return repository.save(user)
    }
}

data class User (val name : String, val userName : String, val age : String)