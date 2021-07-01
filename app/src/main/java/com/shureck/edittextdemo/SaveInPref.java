package com.shureck.edittextdemo;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class SaveInPref {

    public static final String APP_PREFERENCES = "mysettings";
    public String appPreferencesName;
    SharedPreferences mSettings;
    public SaveInPref(Context context) {
        mSettings = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    public void saveText(String appPreferencesName,String text) {
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(appPreferencesName, text);
        editor.apply();
    }

    public String readText(String appPreferencesName){
        if(mSettings.contains(appPreferencesName)) {
            return mSettings.getString(appPreferencesName, "");
        }
        return null;
    }

}
