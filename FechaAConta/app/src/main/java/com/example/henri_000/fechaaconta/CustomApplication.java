package com.example.henri_000.fechaaconta;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;


import com.example.henri_000.fechaaconta.helper.SharedPreferenceHelpers_;

import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.EApplication;
import org.androidannotations.annotations.sharedpreferences.Pref;

/**
 * Created by henri_000 on 21/08/2015.
 */
@EApplication
public class CustomApplication extends Application {

    @Pref
    SharedPreferenceHelpers_ preferences;

    public boolean checkLogin() throws ClassNotFoundException {

        //SharedPreferences preferences = getSharedPreferences(USER_INFO, Context.MODE_PRIVATE);

        String username = preferences.name().get();
        if(username == null || username.equals("")){
            return false;
        }
        return true;
    }


}
