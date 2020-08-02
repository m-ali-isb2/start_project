package com.muhammadali.udemy.stateArt.template.model

import com.muhammadali.udemy.stateArt.template.di.DaggerAPIComponent
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

/**
 * Created by Muhammad Ali on 05-May-20.
 * Email muhammad.ali9385@gmail.com
 */
class DogsService {


    @Inject
    lateinit var api : DogsAPI

    init {
        DaggerAPIComponent.create().injectAPI(this)
    }

    fun getDogs(): Single<List<DogBreed>> {
        return api.getDogs()
    }
}