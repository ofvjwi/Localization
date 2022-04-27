package com.example.localization.activity

import PrefsManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.localization.R

class SharedPreferencesActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var edittextPreferences: EditText
    private lateinit var buttonSavePreferences: Button

    companion object {
        private const val TAG: String = "PreferenceActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        initViews()

    }

    private fun initViews() {
        context = this
        edittextPreferences = findViewById(R.id.edittext_preferences)
        buttonSavePreferences = findViewById(R.id.btn_save_preferences)

        buttonSavePreferences.setOnClickListener {
            val text = edittextPreferences.text.toString()
            //  saveEmail(text)
        }

        val prefsManager = PrefsManager.getInstance(context)
        prefsManager?.saveData("email", "developer_android@gmail.com")
        val data: String? = prefsManager?.getData("email")
        Log.d(TAG, "onCreate: $data")
    }

    private fun saveEmail(email: String?) {
        val prefs = applicationContext.getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString("email", email)
        editor.apply()
    }

    private fun loadEmail(): String? {
        val prefs = applicationContext.getSharedPreferences("MyPrefs", MODE_PRIVATE)
        return prefs.getString("email", "pdp@gmail.com")
    }

    private fun removeEmail() {
        val prefs = applicationContext.getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val editor = prefs.edit()
        editor.remove("email")
        editor.apply()
    }

    private fun clearAll() {
        val prefs = applicationContext.getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }
}


