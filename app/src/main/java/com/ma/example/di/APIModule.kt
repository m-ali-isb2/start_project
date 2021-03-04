package com.ma.example.di

import com.ma.example.model.DogsAPI
import com.ma.example.model.DogsService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Muhammad Ali on 02-Aug-20.
 * Email muhammad.ali9385@gmail.com
 */
@Module
class APIModule {

    private val BASE_URL = "https://raw.githubusercontent.com/"

    @Provides
    fun provideDogsAPI(): DogsAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(DogsAPI::class.java)
    }

    @Provides
    fun provideDogsService(): DogsService {
        return DogsService()
    }
}