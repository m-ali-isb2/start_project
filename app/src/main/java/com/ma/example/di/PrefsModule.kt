package com.ma.example.di

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.ma.example.utils.SharePreferencesHelper
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Singleton

/**
 * Created by Muhammad Ali on 03-Aug-20.
 * Email muhammad.ali9385@gmail.com
 */

@Module
class PrefsModule {

    @Provides
    @Singleton
    @typeOfContext(CONTEXT_APP)
    fun provideSharedPrefs(app: Application): SharePreferencesHelper {
        return SharePreferencesHelper(app)
    }

    @Provides
    @Singleton
    @typeOfContext(CONTEXT_ACTIVITY)
    fun provideSharedPrefsAct(activity: AppCompatActivity): SharePreferencesHelper {
        return SharePreferencesHelper(activity)
    }
}

const val CONTEXT_APP = "app_ctx"
const val CONTEXT_ACTIVITY = "activity_ctx"


@Qualifier
annotation class typeOfContext(val type: String)