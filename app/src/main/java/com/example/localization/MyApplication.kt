package com.example.localization

import android.app.Application
import com.example.localization.manager.LocaleManager

class MyApplication : Application() {

    companion object {
        private val TAG: String = MyApplication::class.java.simpleName.toString()
        lateinit var instance: MyApplication
        lateinit var localeManager: LocaleManager
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        localeManager = LocaleManager(this)
        localeManager.setLocale(this)
    }
}

