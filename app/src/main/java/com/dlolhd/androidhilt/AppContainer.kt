package com.dlolhd.androidhilt

import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.dlolhd.androidhilt.navigator.AppNavigator
import com.dlolhd.androidhilt.navigator.AppNavigatorImpl

interface AppContainer {
    fun provideNavigator(activity: FragmentActivity) : AppNavigator
}

class DefaultAppContainer(applicationContext: Context): AppContainer {
    override fun provideNavigator(activity: FragmentActivity): AppNavigator {
        return AppNavigatorImpl(activity)
    }

}