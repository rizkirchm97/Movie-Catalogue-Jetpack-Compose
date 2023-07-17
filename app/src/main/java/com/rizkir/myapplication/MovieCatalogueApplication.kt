package com.rizkir.myapplication

import android.app.Application
import com.squareup.leakcanary.core.BuildConfig
import dagger.hilt.android.HiltAndroidApp

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
@HiltAndroidApp
class MovieCatalogueApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {

        }
    }
}