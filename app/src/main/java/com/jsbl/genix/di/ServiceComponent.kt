package com.jsbl.genix.di

import com.jsbl.genix.viewModel.ListViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Muhammad Ali on 03-Aug-20.
 * Email muhammad.ali9385@gmail.com
 */

@Singleton
@Component(modules = arrayOf(APIModule::class,PrefsModule::class,AppModule::class))
interface ServiceComponent {

    fun injectViewModel(viewModel: ListViewModel)
}