package com.iesam.androidtrainning.presentation

import android.database.Observable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import com.iesam.androidtrainning.R
import com.iesam.androidtrainning.data.UserDataRepository
import com.iesam.androidtrainning.data.local.xmlLocalDataSource
import com.iesam.androidtrainning.domain.GetUserUseCase
import com.iesam.androidtrainning.domain.SaveUserUseCase
import com.iesam.androidtrainning.domain.User

class MainActivity : AppCompatActivity() {

    val viewModels : MainViewModel  by lazy{
        MainViewModel (
            SaveUserUseCase(UserDataRepository(xmlLocalDataSource(this))),
            GetUserUseCase(UserDataRepository(xmlLocalDataSource(this)))
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        setupView()
        //setupObservers()   //SUSCRIPCION
        //viewModels.getUser()  //EJECUTO EL HILO SECUNDARIO PARA RECOGER LA INFORMACION
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


    private fun setupObservers(){
        val observer = Observer<MainViewModel.UiState>{
            it.user?.apply {
                bindData(this)
            }
        }
        viewModels.uiState.observe(this, observer)
    }

    private fun bindData (user : User){
        setNameInput(user.username)
        setSurnameInput(user.surname)
        setAgeInput(user.age)
    }

    private fun setNameInput(name: String) {
        findViewById<EditText>(R.id.input_name).setText(name)
    }

    private fun setSurnameInput(surname: String) {
        findViewById<EditText>(R.id.input_surname).setText(surname)
    }

    private fun setAgeInput(age: String) {
        findViewById<EditText>(R.id.input_age).setText(age)
    }
}

