package com.dlolhd.androidhilt

import android.app.Application

class AndroidHiltApplication : Application() {

    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = DefaultAppContainer(applicationContext)
    }

}