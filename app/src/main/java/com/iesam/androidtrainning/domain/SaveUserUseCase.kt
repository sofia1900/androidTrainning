package com.iesam.androidtrainning.domain

import com.iesam.androidtrainning.app.ErrorApp
import com.iesam.kotlintrainning.Either

class SaveUserUseCase (private val repository: UserRepository){

    operator fun invoke (user : User) : Either<ErrorApp, Boolean> {
        return repository.save(user)
    }
}

//Se mete aqui porque solo se utiliza cuando se utiliza el caso de uso
//Se deberia de llamar INPUT porque no es un modelo de algo, sino que son
//datos en si.
data class User (val name : String, val userName : String, val age : String)