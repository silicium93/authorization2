package com.shabim.authorization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate

class EditActivity : AppCompatActivity() {

    lateinit var editTextName : EditText
    lateinit var editTextAge : EditText
    lateinit var editTextAddress : EditText
    lateinit var editTextEmail : EditText

    lateinit var buttonSave : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        editTextName = findViewById(R.id.editTextName)
        editTextAge = findViewById(R.id.editTextAge)
        editTextAddress = findViewById(R.id.editTextAddress)
        editTextEmail = findViewById(R.id.editTextEmail)

        buttonSave = findViewById(R.id.buttonSave)

        buttonSave.setOnClickListener{

            if (editTextName.text.isNotEmpty() && editTextAge.text.isNotEmpty() && editTextAddress.text.isNotEmpty() && editTextEmail.text.isNotEmpty()){
                val intent = Intent(this,InfoActivity::class.java)
                intent.putExtra("name", editTextName.text.toString())
                intent.putExtra("age", editTextAge.text.toString())
                intent.putExtra("address", editTextAddress.text.toString())
                intent.putExtra("email", editTextEmail.text.toString())

                startActivity(intent)
            }
            else {
                val toast = Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT)
                toast.show()
            }
        }

        }

    }
