package com.infy.dagger2kotlin.database.prefrences

import android.content.SharedPreferences

import javax.inject.Inject

class MySharedPreferences @Inject
constructor(private val mSharedPreferences: SharedPreferences) {

    fun putData(key: String, data: Int) {
        mSharedPreferences.edit().putInt(key, data).apply()
    }

    fun putData(key: String, data: String) {
        mSharedPreferences.edit().putString(key, data).apply()
    }

    fun putData(key: String, data: Boolean) {
        mSharedPreferences.edit().putBoolean(key, data).apply()
    }

    fun getIntData(key: String): Int {
        return mSharedPreferences.getInt(key, 0)
    }

    fun getStringData(key: String): String? {
        return mSharedPreferences.getString(key, null)
    }

    fun getBooleanData(key: String): Boolean {
        return mSharedPreferences.getBoolean(key, false)
    }

    fun clearPreferences() {
        mSharedPreferences.edit().clear().apply()
    }

    companion object {
        val PREFS_FILE_APP_DATA = "prefs_file_app_data"
        val PREFS_IS_LOGIN = "IsLoggedIn"
        val PREFS_KEY_USER_ID = "userid"
        val PREFS_KEY_SOUND_ON = "prefs_is_sound_on"
        val PREFS_KEY_ACCESS_TOKEN = "prefs_access_token"
        val PREFS_KEY_AUTH = "prefs_auth_key"
        val PREFS_KEY_DEVICE_TOKEN = "prefs_device_token"
    }

}
