package com.iesam.androidtrainning.data.local

import android.content.Context
import com.iesam.androidtrainning.app.ErrorApp
import com.iesam.androidtrainning.domain.User
import com.iesam.kotlintrainning.Either
import com.iesam.kotlintrainning.left
import com.iesam.kotlintrainning.right

class xmlLocalDataSource (private val context : Context){
                                                          //nombre del fichero
    private val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)
                                                                    //Si es accesible desde otra app

    //https://developer.android.com/training/data-storage/shared-preferences?hl=es-419
    fun saveUser(user : User) : Either<ErrorApp, Boolean> {
        /*val editor = sharedPref.edit()
        editor.putString("username", userName)
        editor.putString("surname", surname)
        editor.apply()
        sharedPref.edit()*/

        try{
            with(sharedPref.edit()){
                putString("username", user.name)
                putString("surname", user.userName)
                apply()
            }
            return true.right()
        }catch (ex : Exception){
            return ErrorApp.UnknowError.left()
        }

    }
}