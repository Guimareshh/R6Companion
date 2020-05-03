package com.lucienguimaraes.r6squad.app

import android.view.ViewGroup
import com.lucienguimaraes.arch.navigation.BackPressedListener
import com.lucienguimaraes.arch.navigation.Koordinator
import com.guimaraes.lucien.home.HomeComponent
import com.guimaraes.lucien.home.HomeKoordinator

class AppKoordinatorImpl(
    private val appComponent: ApplicationComponent
) : Koordinator<ApplicationComponent>(appComponent), AppKoordinator, BackPressedListener {

    private var homeComponent: HomeComponent? = null
    private var homeKoordinator: HomeKoordinator? = null


    //region AppKoordinatorImpl
    override fun start() {}

    override fun onRelease() {
        dismissHome()
    }

    override fun onBackPressed(): Boolean = false
    //endregion


    //region Home Feature
    override fun showHome(rootView: ViewGroup) {
        if(homeKoordinator == null) {
            homeComponent = appComponent.plus(
                HomeComponent.Module(rootView) {
                   dismissHome()
                }
            )
            homeKoordinator = homeComponent?.koordinator()
        }

        homeKoordinator?.start()
    }

    override fun dismissHome() {
        homeKoordinator?.onRelease()
        homeKoordinator = null
        homeComponent = null
    }
    //endregion
}

interface AppKoordinator {

    fun showHome(rootView: ViewGroup)
    fun dismissHome()
}