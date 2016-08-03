package com.example.henri_000.fechaaconta;


import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.henri_000.fechaaconta.helper.SharedPreferenceHelpers_;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;


/**
 * Created by henri_000 on 21/08/2015.
 */

@EActivity(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {

    @ViewById(R.id.usernameInput)
    EditText usernameInput;

    @Pref
    SharedPreferenceHelpers_ preferences;

    @Click(R.id.usernameSaveButton)
    public void onSaveAuth(View view){

        //SharedPreferences.Editor preferencesEditor = getSharedPreferences(CustomApplication.USER_INFO, Context.MODE_PRIVATE).edit();

        String username =  usernameInput.getText().toString();
        System.out.println(username);
        if(username == null || username.equals("")){
            Toast.makeText(this, "Cadastre um nome nao vazio!", Toast.LENGTH_SHORT).show();
        }else{
            //preferencesEditor.putString(CustomApplication.USER_INFO_NAME, usernameInput.getText().toString());
            //preferencesEditor.apply();
            preferences.edit().name().put(username).apply();

            //Intent intent = new Intent(this, MainActivity.class);
            //startActivity(intent);
            MainActivity_.intent(this).start();
        }
    }
}
