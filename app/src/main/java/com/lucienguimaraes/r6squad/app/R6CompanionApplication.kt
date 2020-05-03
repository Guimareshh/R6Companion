package com.lucienguimaraes.r6squad.app

import android.app.Application

class R6CompanionApplication : Application() {

    val applicationComponent: ApplicationComponent = DaggerApplicationComponent.create()

}