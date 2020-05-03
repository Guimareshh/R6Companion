package com.lucienguimaraes.r6squad.app

import com.lucienguimaraes.network.NetworkModule
import com.guimaraes.lucien.home.HomeComponent
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationComponent.AppModule::class])
interface ApplicationComponent  {

    fun koordinator(): AppKoordinator

    fun plus(module: HomeComponent.Module): HomeComponent

    @Module(
        includes = [NetworkModule::class]
    )
    class AppModule {

        @Provides
        internal fun provideIODispatcher() = Dispatchers.IO

        @Provides
        internal fun provideMainDispatcher() = Dispatchers.Main

        @Provides
        internal fun provideAppKoordinator(
            component: ApplicationComponent
        ) : AppKoordinator = AppKoordinatorImpl(component)
    }
}
