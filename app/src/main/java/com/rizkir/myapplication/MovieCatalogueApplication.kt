package com.rizkir.myapplication

import android.app.Application
import android.util.Log
import com.rizkir.di.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
@HiltAndroidApp
class MovieCatalogueApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Log.e("Application", "Debug Mode")
            Timber.plant(Timber.DebugTree())
        }
    }
}