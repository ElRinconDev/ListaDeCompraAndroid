package com.example.listacompra

import android.app.Application

class ProductoApplication : Application() {
    companion object{
        lateinit var prefs: Preferences
    }
    override fun onCreate() {
        super.onCreate()
        prefs = Preferences(baseContext)

    }

}