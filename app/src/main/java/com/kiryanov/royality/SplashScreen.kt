package com.kiryanov.royality

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kiryanov.royality.mvp.GreetingScreen.GreetingActivity
import com.kiryanov.royality.mvp.MainScreen.NewMainActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val clazz =  if (CurrentUser.getInstance().isLogged) NewMainActivity::class
        else GreetingActivity::class

        startActivity(Intent(this, clazz.java))
        finish()
    }
}