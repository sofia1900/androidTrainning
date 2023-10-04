package com.iesam.androidtrainning.presentation

import androidx.lifecycle.ViewModel
import com.iesam.androidtrainning.domain.SaveUserUseCase

class MainViewModel (private val saveUserUseCase : SaveUserUseCase) : ViewModel(){

    fun saveUser(name : String, surname : String){
        val result = saveUserUseCase(name, surname)
    }
}