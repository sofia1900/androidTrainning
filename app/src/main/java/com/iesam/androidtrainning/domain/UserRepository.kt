package com.iesam.androidtrainning.domain

import com.iesam.androidtrainning.app.ErrorApp
import com.iesam.kotlintrainning.Either

interface UserRepository {

    fun save(name : String, surname : String) : Either<ErrorApp, Boolean>

}