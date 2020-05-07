package com.guimaraes.lucien.news

import com.lucienguimaraes.arch.navigation.BackPressedListener
import com.lucienguimaraes.arch.navigation.Koordinator

class NewsKoordinatorImpl(
    component: NewsComponent
) : Koordinator<NewsComponent>(component), NewsKoordinator, BackPressedListener {

    override fun start() {
        component.viewHolder().showOnRootView()
    }

    override fun onRelease() {
        component.viewHolder().dismissFromRootView()
    }

    override fun onBackPressed(): Boolean = true
}

interface NewsKoordinator {
    fun start()
    fun onRelease()
}