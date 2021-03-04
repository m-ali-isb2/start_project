package com.jsbl.genix.model

import com.jsbl.genix.di.DaggerAPIComponent
import io.reactivex.Single
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