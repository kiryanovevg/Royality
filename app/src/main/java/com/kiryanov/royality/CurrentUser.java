package com.kiryanov.royality;

import android.content.SharedPreferences;

import com.evgeniy.royality.App;

import javax.inject.Inject;

public class CurrentUser {

    private static CurrentUser instance;

    @Inject
    SharedPreferences preferences;

    private String json;

    private CurrentUser() {
        App.component.inject(this);
        json = preferences.getString(ConstantsKt.USER_JSON, "");
    }

    public static CurrentUser getInstance() {
        if (instance == null) instance = new CurrentUser();
        return instance;
    }

    public boolean isLogged() {
        return !json.isEmpty();
    }

    public void withoutLogin() {
        json = ConstantsKt.WITHOUT_LOGIN;
        preferences.edit().putString(ConstantsKt.USER_JSON, json).apply();
    }
}
