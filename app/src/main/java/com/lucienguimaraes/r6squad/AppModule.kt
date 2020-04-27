package com.lucienguimaraes.r6squad

import com.lucienguimaraes.network.NetworkConnector
import com.lucienguimaraes.network.NetworkModule
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
class AppModule {

    @Provides
    internal fun provideGithubRepository(
        networkConnector: NetworkConnector
    ): GithubRepository = GithubRepositoryImpl(
        networkConnector.create(GitHubApi::class.java)
    )
}