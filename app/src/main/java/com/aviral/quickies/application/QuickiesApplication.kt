package com.aviral.quickies.application

import android.app.Application
import com.aviral.quickies.di.AppModule
import com.aviral.quickies.di.AppModuleImplementation

class QuickiesApplication : Application() {

    companion object {
        lateinit var appModule: AppModule
    }

    override fun onCreate() {
        super.onCreate()

        appModule = AppModuleImplementation()
    }

}