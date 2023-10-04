package com.iesam.androidtrainning.domain

import com.iesam.androidtrainning.app.ErrorApp
import com.iesam.kotlintrainning.Either

interface UserRepository {

    fun save(user : User) : Either<ErrorApp, Boolean>

}