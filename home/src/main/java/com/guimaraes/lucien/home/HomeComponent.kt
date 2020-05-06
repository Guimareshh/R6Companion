package com.guimaraes.lucien.home

import android.view.ViewGroup
import com.lucienguimaraes.network.NetworkConnector
import dagger.Provides
import dagger.Subcomponent
import kotlinx.coroutines.MainCoroutineDispatcher
import javax.inject.Scope

@HomeScope
@Subcomponent(modules = [HomeComponent.Module::class])
interface HomeComponent {

    fun viewHolder(): HomeViewHolder
    fun interactor(): HomeInteractor
    fun koordinator(): HomeKoordinator

    @dagger.Module
    class Module(
        private val rootView: ViewGroup,
        private val dismissCallback: () -> Unit
    ) {

        @HomeScope
        @Provides
        internal fun provideHomeKoordinator(
            component: HomeComponent
        ) : HomeKoordinator = HomeKoordinatorImpl(component)


        @HomeScope
        @Provides
        internal fun provideHomeRepository(
            networkConnector: NetworkConnector
        ): HomeRepository =
            HomeRepositoryImpl(
                networkConnector.create(HomeApi::class.java)
            )


        @HomeScope
        @Provides
        internal fun provideHomeInteractor(
            homeRepository: HomeRepository
        ) : HomeInteractor = HomeInteractorImpl(homeRepository, dismissCallback)


        @HomeScope
        @Provides
        internal fun provideHomeViewModel() = HomeViewModel()


        @HomeScope
        @Provides
        internal fun provideIn(
            homeInteractor: HomeInteractor
        ): HomeInputs = homeInteractor

        @HomeScope
        @Provides
        internal fun provideOut(
            homeViewModel: HomeViewModel
        ): HomeOutputs = homeViewModel

        @HomeScope
        @Provides
        internal fun provideHomeViewHolder(
            viewModel: HomeViewModel,
            homeInteractor: HomeInteractor,
            mainCoroutineDispatcher: MainCoroutineDispatcher
        ) = HomeViewHolder(rootView, mainCoroutineDispatcher).apply {
            inputs = homeInteractor
            outputs = viewModel
        }
    }
}

@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class HomeScope