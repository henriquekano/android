package com.example.henri_000.services;


import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by henri_000 on 19/08/2015.
 */
public class SimpleIntentService extends IntentService {

    private static final String TAG = "com.example.henri_000";



    public SimpleIntentService(){
        super("SimpleIntentService");
    }



    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "service");
    }
}
