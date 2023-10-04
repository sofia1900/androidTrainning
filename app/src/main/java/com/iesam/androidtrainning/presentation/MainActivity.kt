package com.iesam.androidtrainning.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import com.iesam.androidtrainning.R
import com.iesam.androidtrainning.data.UserDataRepository
import com.iesam.androidtrainning.domain.SaveUserUseCase

class MainActivity : AppCompatActivity() {

    val viewModels : MainViewModel = MainViewModel(
        SaveUserUseCase(UserDataRepository())
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        setupView()
    }


    private fun setupView(){
        val actionButton = findViewById<Button>(R.id.action_save)
        actionButton.setOnClickListener {viewModels.saveUser(getNameInput(), getSurnameInput())}
    }

    private fun getNameInput() : String =
        findViewById<EditText>(R.id.input_name).text.toString()

    private fun getSurnameInput() : String =
        findViewById<EditText>(R.id.input_surname).text.toString()


}

