package com.iesam.androidtrainning.domain

import com.iesam.androidtrainning.app.ErrorApp
import com.iesam.kotlintrainning.Either

class SaveUserUseCase (private val repository: UserRepository){

    operator fun invoke (name : String, surname : String) : Either<ErrorApp, Boolean> {
        return repository.save(name, surname)
    }
}