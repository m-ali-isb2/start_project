package com.jsbl.genix.di

import com.jsbl.genix.model.DogsService
import dagger.Component

/**
 * Created by Muhammad Ali on 03-Aug-20.
 * Email muhammad.ali9385@gmail.com
 */
@Component(modules = arrayOf(APIModule::class))
interface APIComponent {

    fun injectAPI(service: DogsService)

}