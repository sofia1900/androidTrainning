package com.iesam.androidtrainning.presentation

import androidx.lifecycle.ViewModel
import com.iesam.androidtrainning.app.ErrorApp
import com.iesam.androidtrainning.domain.SaveUserUseCase
import com.iesam.androidtrainning.domain.User

class MainViewModel (private val saveUserUseCase : SaveUserUseCase) : ViewModel(){

    fun saveUser(user : User){
        saveUserUseCase(user).fold(
            {responseError(it)},
            {responseSuccess(it)}
        )
    }

    private fun responseError (errorApp: ErrorApp){

    }

    private fun responseSuccess(isOk : Boolean){

    }
}