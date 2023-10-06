package com.iesam.androidtrainning.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iesam.androidtrainning.app.ErrorApp
import com.iesam.androidtrainning.domain.SaveUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (private val saveUserUseCase : SaveUserUseCase) : ViewModel(){

    fun saveUser(name: String, surname: String, date: String) {
        saveUserUseCase(SaveUserUseCase.Input(name, surname, date)).fold(
            { responseError(it) },
            { responseSuccess(it) }
        )
    }

    private fun responseError (errorApp: ErrorApp){

    }

    private fun responseSuccess(isOk : Boolean){

    }
}