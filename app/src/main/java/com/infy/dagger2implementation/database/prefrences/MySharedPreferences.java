package com.infy.dagger2implementation.database.prefrences;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class MySharedPreferences {
    public static final String PREFS_FILE_APP_DATA = "prefs_file_app_data";
    public static final String PREFS_IS_LOGIN = "IsLoggedIn";
    public static final String PREFS_KEY_USER_ID = "userid";
    public static final String PREFS_KEY_SOUND_ON = "prefs_is_sound_on";
    public static final String PREFS_KEY_ACCESS_TOKEN = "prefs_access_token";
    public static final String PREFS_KEY_AUTH = "prefs_auth_key";
    public static final String PREFS_KEY_DEVICE_TOKEN= "prefs_device_token";


    private SharedPreferences mSharedPreferences;

    @Inject
    public MySharedPreferences(SharedPreferences mSharedPreferences) {
        this.mSharedPreferences = mSharedPreferences;
    }

    public void putData(String key, int data) {
        mSharedPreferences.edit().putInt(key, data).apply();
    }

    public void putData(String key, String data) {
        mSharedPreferences.edit().putString(key, data).apply();
    }

    public void putData(String key, boolean data) {
        mSharedPreferences.edit().putBoolean(key, data).apply();
    }

    public int getIntData(String key) {
        return mSharedPreferences.getInt(key, 0);
    }

    public String getStringData(String key) {
        return mSharedPreferences.getString(key, null);
    }

    public boolean getBooleanData(String key) {
        return mSharedPreferences.getBoolean(key, false);
    }
    public void clearPreferences(){
        mSharedPreferences.edit().clear().apply();
    }

}
