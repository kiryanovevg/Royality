package com.evgeniy.royality.DI

import com.evgeniy.restapp.DI.Modules.AndroidModule
import com.evgeniy.restapp.DI.Modules.NetModule
import com.evgeniy.restapp.DI.Modules.RepositoryModule
import com.evgeniy.royality.App
import com.kiryanov.royality.CurrentUser
import com.kiryanov.royality.mvp.MainScreen.MainPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidModule::class, NetModule::class, RepositoryModule::class])
interface AppComponent {
    //Injects
    fun inject(app: App)
    fun inject(currentUser: CurrentUser)
    fun inject(mainPresenter: MainPresenter)
}