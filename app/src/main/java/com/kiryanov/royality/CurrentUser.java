package com.kiryanov.royality;

import android.content.SharedPreferences;

import com.evgeniy.royality.App;
import com.google.gson.Gson;
import com.kiryanov.royality.data.User;

import javax.inject.Inject;

public class CurrentUser {

    private static final String EMPTY_STRING = "";

    private static CurrentUser instance;

    @Inject
    SharedPreferences preferences;

    private String json;

    private CurrentUser() {
        App.component.inject(this);
        json = preferences.getString(ConstantsKt.USER_JSON, EMPTY_STRING);
    }

    public static CurrentUser getInstance() {
        if (instance == null) instance = new CurrentUser();
        return instance;
    }

    public User getUser() {
        User user = null;

        if (isLogged() && !json.equals(ConstantsKt.WITHOUT_LOGIN)) {
            user = new Gson().fromJson(json, User.class);
        }

        return user;
    }

    public void login(String json) {
        this.json = json;
        save();
    }

    public void withoutLogin() {
        json = ConstantsKt.WITHOUT_LOGIN;
        save();
    }

    public void logout() {
        json = EMPTY_STRING;
        save();
    }

    private void save() {
        preferences.edit().putString(ConstantsKt.USER_JSON, json).apply();
    }

    public boolean isLogged() {
        return !json.isEmpty();
    }
}
