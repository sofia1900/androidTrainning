package com.iesam.androidtrainning.data

import com.iesam.androidtrainning.app.ErrorApp
import com.iesam.androidtrainning.data.local.xmlLocalDataSource
import com.iesam.androidtrainning.domain.User
import com.iesam.androidtrainning.domain.UserRepository
import com.iesam.kotlintrainning.Either

class UserDataRepository (private val localDataSource: xmlLocalDataSource): UserRepository {
    override fun save(user : User): Either<ErrorApp, Boolean> {
        //simulo que lo guardo en local
        return Either.Right(true);
    }
}