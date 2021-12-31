package com.abidingtech.www.androidbactch11.Common;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

import com.abidingtech.www.androidbactch11.Lecture8.LoginActivity;

public class Common {
    public static final String LOGIN="login";

    public static void startSomeActivity(Activity source, Class<?> destination) {
        Intent intent=new Intent(source,destination);
        source.startActivity(intent);
        source.finish();
    }
    public static void setSharedPreference(Activity activity,String email, String pass) {
        SharedPreferences.Editor sp=activity.getSharedPreferences(LOGIN,0).edit();
        sp.putString("email",email);
        sp.putString("pass",pass);
        sp.apply();
    }
}
