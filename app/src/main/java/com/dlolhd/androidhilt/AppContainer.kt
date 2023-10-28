package com.dlolhd.androidhilt

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.room.Room
import com.dlolhd.androidhilt.data.AppDatabase
import com.dlolhd.androidhilt.data.LoggerLocalDataSource
import com.dlolhd.androidhilt.navigator.AppNavigator
import com.dlolhd.androidhilt.navigator.AppNavigatorImpl
import com.dlolhd.androidhilt.util.DateFormatter

/*interface AppContainer {
    fun provideNavigator(activity: FragmentActivity) : AppNavigator
    val loggerDataSource : LoggerLocalDataSource
    fun provideDateFormatter() : DateFormatter
}

class DefaultAppContainer(applicationContext: Context): AppContainer {

    private val logsDatabase = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java,
        "logging.db"
    ).build()

    override val loggerDataSource: LoggerLocalDataSource by lazy {
        LoggerLocalDataSource(logsDatabase.logDao())
    }

    override fun provideDateFormatter() = DateFormatter()

    override fun provideNavigator(activity: FragmentActivity): AppNavigator {
        return AppNavigatorImpl(activity)
    }

}*/