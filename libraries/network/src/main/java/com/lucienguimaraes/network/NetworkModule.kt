package com.lucienguimaraes.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    internal fun provideMoshi(
    ) = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Singleton
    @Provides
    internal fun provideRetrofit(
        moshi: Moshi
    ) = Retrofit.Builder()
        .baseUrl("http://192.168.1.6:8080/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Singleton
    @Provides
    internal fun provideConnector(
        retrofit: Retrofit
    ): NetworkConnector = NetworkConnectorImpl(retrofit)
}
