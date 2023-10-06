package com.iesam.androidtrainning.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.iesam.androidtrainning.R
import com.iesam.androidtrainning.data.UserDataRepository
import com.iesam.androidtrainning.data.local.xmlLocalDataSource
import com.iesam.androidtrainning.domain.SaveUserUseCase
import com.iesam.androidtrainning.domain.User

class MainActivity : AppCompatActivity() {

    val viewModels : MainViewModel  by lazy{
        MainViewModel (
            SaveUserUseCase(UserDataRepository(xmlLocalDataSource(this)))
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        setupView()
    }


    private fun setupView(){
        val actionButton = findViewById<Button>(R.id.action_save)
        actionButton.setOnClickListener {
            viewModels.saveUser(getNameInput(), getSurnameInput(), getAgeInput())
        }
    }

    private fun getNameInput() : String =
        findViewById<EditText>(R.id.input_name).text.toString()

    private fun getSurnameInput() : String =
        findViewById<EditText>(R.id.input_surname).text.toString()


    private fun getAgeInput() : String =
        findViewById<EditText>(R.id.input_age).text.toString()
}

