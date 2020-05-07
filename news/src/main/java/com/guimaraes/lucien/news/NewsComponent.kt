package com.guimaraes.lucien.news

import android.view.ViewGroup
import com.lucienguimaraes.network.NetworkConnector
import dagger.Provides
import dagger.Subcomponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.MainCoroutineDispatcher
import javax.inject.Scope

@NewsScope
@Subcomponent(modules = [NewsComponent.Module::class])
interface NewsComponent {

    fun viewHolder(): NewsViewHolder
    fun interactor(): NewsInteractor
    fun koordinator(): NewsKoordinator

    @dagger.Module
    class Module(
        private val rootView: ViewGroup,
        private val dismissCallback: () -> Unit
    ) {

        @NewsScope
        @Provides
        internal fun provideNewsKoordinator(
            component: NewsComponent
        ) : NewsKoordinator = NewsKoordinatorImpl(component)


        @NewsScope
        @Provides
        internal fun provideNewsRepository(
            networkConnector: NetworkConnector
        ): NewsRepository =
            NewsRepositoryImpl(
                networkConnector.create(NewsApi::class.java)
            )


        @NewsScope
        @Provides
        internal fun provideNewsInteractor(
            newsRepository: NewsRepository,
            ioDispatcher: CoroutineDispatcher
        ) : NewsInteractor = NewsInteractorImpl(newsRepository, dismissCallback, ioDispatcher)


        @NewsScope
        @Provides
        internal fun provideNewsViewModel(
            newsInteractor: NewsInteractor
        ) = NewsViewModel(newsInteractor)


        @NewsScope
        @Provides
        internal fun provideIn(
            newsInteractor: NewsInteractor
        ): NewsInputs = newsInteractor

        @NewsScope
        @Provides
        internal fun provideOut(
            newsViewModel: NewsViewModel
        ): NewsOutputs = newsViewModel

        @NewsScope
        @Provides
        internal fun provideNewsViewHolder(
            viewModel: NewsViewModel,
            newsInteractor: NewsInteractor,
            mainCoroutineDispatcher: MainCoroutineDispatcher
        ) = NewsViewHolder(rootView, mainCoroutineDispatcher).apply {
            inputs = newsInteractor
            outputs = viewModel
        }
    }
}

@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class NewsScope