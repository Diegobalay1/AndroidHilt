package com.dlolhd.androidhilt.di

import android.content.Context
import androidx.room.Room
import com.dlolhd.androidhilt.data.AppDatabase
import com.dlolhd.androidhilt.data.LogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * En Kotlin, los módulos que solo contienen funciones @Provides pueden ser clases object.
 * De esta manera, los proveedores se optimizan y prácticamente se alinean en el código generado.
 */
@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "logging.db"
        ).build()
    }

    /**
     * Los parámetros de función son las dependencias del tipo.
     */
    @Provides
    fun provideLogDao(database: AppDatabase): LogDao {
        return database.logDao()
    }

}