package com.example.localization.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.localization.R

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var buttonLanguage: Button
    private lateinit var buttonPreference: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        context = this
        buttonLanguage = findViewById(R.id.btn_home)
        buttonPreference = findViewById(R.id.btn_preference)

        //   buttonHome.text = getString(R.string.app_name)

        buttonLanguage.setOnClickListener {
            callLanguageActivity()
        }
        buttonPreference.setOnClickListener {
            callPreferenceActivity()
        }
    }

    private fun callLanguageActivity() {
        startActivity(Intent(context, LanguageActivity::class.java))
    }

    private fun callPreferenceActivity() {
        startActivity(Intent(context, SharedPreferencesActivity::class.java))
    }
}


