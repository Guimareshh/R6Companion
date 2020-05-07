package com.lucienguimaraes.r6squad.app

import android.view.ViewGroup
import com.lucienguimaraes.arch.navigation.BackPressedListener
import com.lucienguimaraes.arch.navigation.Koordinator
import com.guimaraes.lucien.news.NewsComponent
import com.guimaraes.lucien.news.NewsKoordinator

class AppKoordinatorImpl(
    private val appComponent: ApplicationComponent
) : Koordinator<ApplicationComponent>(appComponent), AppKoordinator, BackPressedListener {

    private var newsComponent: NewsComponent? = null
    private var newsKoordinator: NewsKoordinator? = null


    //region AppKoordinatorImpl
    override fun start() {}

    override fun onRelease() {
        dismissNewsList()
    }

    override fun onBackPressed(): Boolean = false
    //endregion


    //region News Feature
    override fun showNewsList(rootView: ViewGroup) {
        if(newsKoordinator == null) {
            newsComponent = appComponent.plus(
                NewsComponent.Module(rootView) {
                   dismissNewsList()
                }
            )
            newsKoordinator = newsComponent?.koordinator()
        }

        newsKoordinator?.start()
    }

    override fun dismissNewsList() {
        newsKoordinator?.onRelease()
        newsKoordinator = null
        newsComponent = null
    }
    //endregion
}

interface AppKoordinator {

    fun showNewsList(rootView: ViewGroup)
    fun dismissNewsList()
}