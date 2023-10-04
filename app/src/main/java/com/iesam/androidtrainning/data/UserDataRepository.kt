package com.iesam.androidtrainning.data

import com.iesam.androidtrainning.app.ErrorApp
import com.iesam.androidtrainning.domain.UserRepository
import com.iesam.kotlintrainning.Either

class UserDataRepository : UserRepository {
    override fun save(name: String, surname: String): Either<ErrorApp, Boolean> {
        //simulo que lo guardo en local
        return Either.Right(true);
    }
}