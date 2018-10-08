package com.evgeniy.royality.DI

import com.evgeniy.restapp.DI.Modules.AndroidModule
import com.evgeniy.restapp.DI.Modules.NetModule
import com.evgeniy.restapp.DI.Modules.RepositoryModule
import com.evgeniy.royality.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidModule::class, NetModule::class, RepositoryModule::class])
interface AppComponent {
    //Injects
    fun inject(app: App)
}