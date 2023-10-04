package com.iesam.androidtrainning.domain

import com.iesam.androidtrainning.app.ErrorApp
import com.iesam.kotlintrainning.Either

class SaveUserUseCase {

    operator fun invoke (name : String, surname : String) : Either<ErrorApp, Boolean> {

    }
}