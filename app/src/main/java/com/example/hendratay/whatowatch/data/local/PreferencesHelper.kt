package com.example.hendratay.whatowatch.data.local

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class PreferencesHelper @Inject constructor(context: Context) {

    companion object {
        private const val PREF_WHATOWATCH_PACKAGE_NAME = "com.example.hendratay.whatowatch.preferences"
        private const val PREF_KEY_REQUEST_TOKEN = "Request Token"
    }

    private val sharedPref: SharedPreferences = context.getSharedPreferences(PREF_WHATOWATCH_PACKAGE_NAME, Context.MODE_PRIVATE)

    var requestToken: String
        get() = sharedPref.getString(PREF_KEY_REQUEST_TOKEN, "")
        set(accessToken) = sharedPref.edit().putString(PREF_KEY_REQUEST_TOKEN, accessToken).apply()

}