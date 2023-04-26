package com.example.listacompra

import android.content.Context
import android.content.SharedPreferences

class Preferences(context: Context) {
    companion object {
        const val PREFS_NAME = "myDatabase"
        const val PRODUCTOS = "product_value"
    }

    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    fun saveProductos(productos: List<String>){
        prefs.edit().putStringSet(PRODUCTOS, productos.toSet()).apply()
    }
    fun getProductos(): MutableList<String>{
        return prefs.getStringSet(PRODUCTOS, emptySet<String>())?.toMutableList() ?: mutableListOf()

    }
}