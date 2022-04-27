package com.example.localization.activity

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.localization.MyApplication
import com.example.localization.R
import com.example.localization.manager.LocaleManager
import java.util.*

class LanguageActivity : AppCompatActivity() {

    companion object {
        private const val TAG: String = "LanguageActivity"
    }

    private lateinit var context: Context
    private lateinit var buttonEnglish: Button
    private lateinit var buttonRussian: Button
    private lateinit var buttonUzbek: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)
        initViews()


    }


    private fun initViews() {
        context = this
        buttonEnglish = findViewById(R.id.btn_english)
        buttonRussian = findViewById(R.id.btn_russian)
        buttonUzbek = findViewById(R.id.btn_uzbek)

        buttonEnglish.setOnClickListener {
            MyApplication.localeManager.setNewLocale(context, LocaleManager.LANGUAGE_ENGLISH)
            finish()
        }

        buttonRussian.setOnClickListener {
            MyApplication.localeManager.setNewLocale(context, LocaleManager.LANGUAGE_RUSSIAN)
            finish()
        }

        buttonUzbek.setOnClickListener {
            MyApplication.localeManager.setNewLocale(context, LocaleManager.LANGUAGE_UZBEK)
            finish()
        }

//         one = 1
         val one = resources.getQuantityString(R.plurals.my_cats, 1, 1)

//         few = 2-4
          val few = resources.getQuantityString(R.plurals.my_cats, 2, 3)

//         other = 5-
         val other = resources.getQuantityString(R.plurals.my_cats, 5, 10)

          Log.d(TAG, "@@@one: $one")
          Log.d(TAG, "@@@few: $few")
          Log.d(TAG, "@@@other: $other")

    }

    private fun setLocale(language: String) {
        // en, ru, uz and etc
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        finish()
    }
}


