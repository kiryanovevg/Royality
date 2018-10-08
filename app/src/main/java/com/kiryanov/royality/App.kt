package com.evgeniy.royality

import android.app.Application
import com.evgeniy.royality.DI.AppComponent

class App : Application() {

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

//        component = initDaggerComponent()
//        component.inject(this)
    }

//    private fun initDaggerComponent(): AppComponent {
//        return DaggerAppComponent.builder()
//                .netModule(NetModule(getString(R.string.base_url)))
//                .androidModule(AndroidModule(this))
//                .repositoryModule(RepositoryModule())
//                .build()
//    }
}