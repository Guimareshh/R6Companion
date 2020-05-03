package com.guimaraes.lucien.home

import com.lucienguimaraes.arch.navigation.BackPressedListener
import com.lucienguimaraes.arch.navigation.Koordinator

class HomeKoordinatorImpl(
    component: HomeComponent
) : Koordinator<HomeComponent>(component), HomeKoordinator, BackPressedListener {

    override fun start() {
        component.viewHolder().showOnRootView()
    }

    override fun onRelease() {
        component.viewHolder().dismissFromRootView()
    }

    override fun onBackPressed(): Boolean = true
}

interface HomeKoordinator {
    fun start()
    fun onRelease()
}