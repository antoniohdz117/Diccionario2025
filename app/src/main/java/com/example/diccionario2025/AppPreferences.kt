package com.example.diccionario2025

import android.content.ContentProviderOperation
import android.content.Context
import android.content.SharedPreferences

object AppPreferences {

    lateinit var preferences: SharedPreferences
    private const val NAME = "conjuntoSharedPreferences"
    private const val MODE = Context.MODE_PRIVATE

    private val QUERYTEXT = Pair("queryText", String())

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit ){
        val editor = edit()
        operation(editor)
        editor.apply()
    }


     var queryText: String
        get() = preferences.getString(QUERYTEXT.first, QUERYTEXT.second).toString()
        set(value) = preferences.edit{it.putString("queryText", value)}

}