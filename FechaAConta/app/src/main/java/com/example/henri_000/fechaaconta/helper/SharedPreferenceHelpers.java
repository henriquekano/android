package com.example.henri_000.fechaaconta.helper;

import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by henri_000 on 24/08/2015.
 */
@SharedPref(value = SharedPref.Scope.UNIQUE)
public interface SharedPreferenceHelpers {

    @DefaultString("")
    String name();
}
