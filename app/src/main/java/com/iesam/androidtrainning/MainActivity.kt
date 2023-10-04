package com.iesam.androidtrainning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        setupView()

    }

    private fun setupView(){
        val actionButton = findViewById<Button>(R.id.action_save)
        actionButton.setOnClickListener {
            Log.d("@dev", "Name: ${this.getNameInput()}")
            Log.d("@dev", "Surname: ${this.getSurnameInput()}")
        }
    }


    private fun getNameInput() : String =
        findViewById<EditText>(R.id.input_name).text.toString()

    private fun getSurnameInput() : String =
        findViewById<EditText>(R.id.input_surname).text.toString()


}

