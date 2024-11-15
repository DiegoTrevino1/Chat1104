//import package
package com.example.chat_1104.utilities;

//import statement
import android.content.Context;
import android.content.SharedPreferences;

        //create PreferenceManager class
public class PreferenceManager {

    //define SharedPreferences
    private final SharedPreferences sharedPreferences;

    public PreferenceManager(Context context) {
        sharedPreferences = context.getSharedPreferences(Constants.KEY_PREFERENCE_NAME,Context.MODE_PRIVATE);

    }

    //create putBoolean function
    public void putBoolean(String key, Boolean value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key,value);
        editor.apply();
    }

    //create getBoolean method
    public Boolean getBoolean(String key){
        return sharedPreferences.getBoolean(key, false);
    }

    //create putString method
    public void putString(String key, String value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key,value);
        editor.apply();

    }

    //create getString method
    public String getString(String key){
        return sharedPreferences.getString(key, null);
    }

    //create clear method
    public void clear(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }


}
