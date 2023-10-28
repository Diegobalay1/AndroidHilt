package com.dlolhd.androidhilt.di

import com.dlolhd.androidhilt.navigator.AppNavigator
import com.dlolhd.androidhilt.navigator.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class NavigationModule {

    @Binds
    abstract fun bindNavigator(navigatorImpl: AppNavigatorImpl) : AppNavigator

}