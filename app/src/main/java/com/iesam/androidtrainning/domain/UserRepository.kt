package com.iesam.androidtrainning.domain

interface UserRepository {

    fun save(name : String, surname : String)

}