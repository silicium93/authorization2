package com.shabim.authorization

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class InfoActivity : AppCompatActivity() {

    lateinit var textViewAge: TextView
    lateinit var textViewName: TextView
    lateinit var textViewAddress: TextView
    lateinit var textViewEmail: TextView

    lateinit var buttonSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        textViewAge = findViewById(R.id.textViewAge)
        textViewName = findViewById(R.id.textViewName)
        textViewAddress = findViewById(R.id.textViewAddress)
        textViewEmail = findViewById(R.id.textViewEmail)

        buttonSend = findViewById(R.id.buttonSend)

        textViewName.text = "Имя: ${intent.getStringExtra("name")}"
        textViewAge.text = "Возраст: ${intent.getStringExtra("age")}"
        textViewAddress.text = "Адрес: ${intent.getStringExtra("address")}"
        textViewEmail.text = "E-mail: ${intent.getStringExtra("email")}"

        buttonSend.setOnClickListener {

            val textMsg =
                textViewName.text.toString() + "\n" + textViewAge.text.toString() + "\n" + textViewAddress.text.toString() + "\n" + textViewEmail.text.toString()

            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND;
                putExtra(Intent.EXTRA_TEXT, textMsg)
                type = "text/plain"
            }

            try {
                startActivity(sendIntent)
            } catch (e: ActivityNotFoundException) {
                val toast = Toast.makeText(
                    this,
                    "Подходящее приложение для отправки не найдено",
                    Toast.LENGTH_SHORT
                )
                toast.show()
            }
        }

    }
}