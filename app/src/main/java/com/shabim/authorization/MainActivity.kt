package com.shabim.authorization

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.isGone

class MainActivity : AppCompatActivity() {

    private lateinit var buttonCreateUser: Button
    private lateinit var buttonApplyTheme: Button
    private lateinit var spinnerThemes: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCreateUser = findViewById(R.id.buttonCreateUser);
        buttonApplyTheme = findViewById(R.id.buttonApplyTheme)
        spinnerThemes = findViewById(R.id.spinner_Themes)

        buttonCreateUser.setOnClickListener {
            val intent: Intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }

        buttonApplyTheme.setOnClickListener() {
            when (spinnerThemes.selectedItemPosition) {
                0 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
                1 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
                2 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                }
            }

        }

    }
}






