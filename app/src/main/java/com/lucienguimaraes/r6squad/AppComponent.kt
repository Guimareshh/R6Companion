package com.lucienguimaraes.r6squad

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface ApplicationComponent  {

    fun injectHomeActivity(homeActivity: HomeActivity)

}
