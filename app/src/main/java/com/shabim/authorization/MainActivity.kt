package com.shabim.authorization

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isGone

class MainActivity : AppCompatActivity() {

    lateinit var buttonCreateUser : Button
    lateinit var switchTheme: Switch
    lateinit var checkBoxThemeInSystem : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCreateUser = findViewById(R.id.buttonCreateUser);
        checkBoxThemeInSystem = findViewById(R.id.checkBoxThemeInSystem)
        switchTheme = findViewById(R.id.switchTheme)


        setThemeSwitch()

        buttonCreateUser.setOnClickListener{
            val intent: Intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }

        checkBoxThemeInSystem.setOnClickListener(){
            if (checkBoxThemeInSystem.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
            setThemeSwitch()
        }

        switchTheme.setOnClickListener(){
            if (checkBoxThemeInSystem.isChecked)
                checkBoxThemeInSystem.isChecked = false

            if(switchTheme.isChecked)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

            else if (!switchTheme.isChecked)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        }

}
    private fun setThemeSwitch(){

        when(resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK){
            Configuration.UI_MODE_NIGHT_YES -> {
                switchTheme.isChecked = true
                switchTheme.text = "Тёмная тема"
            }
            Configuration.UI_MODE_NIGHT_NO ->{
                switchTheme.isChecked = false
                switchTheme.text = "Светлая тема"
            }
        }

    }

    }
