package com.dlolhd.androidhilt.data

import android.os.Looper
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import android.os.Handler
import javax.inject.Inject
import javax.inject.Singleton

//@Singleton
class LoggerLocalDataSource @Inject constructor(
    private val logDao: LogDao
) : LoggerDataSource {
    private val executorService: ExecutorService = Executors.newFixedThreadPool(4)
    private val mainThreadHandler by lazy {
        Handler(Looper.getMainLooper())
    }

    override fun addLog(title: String, msg: String) {
        executorService.execute {
            logDao.insertAll(
                Log(
                    title,
                    msg,
                    System.currentTimeMillis()
                )
            )
        }
    }

    override fun getAllLogs(callback: (List<Log>) -> Unit) {
        executorService.execute {
            val logs = logDao.getAll()
            mainThreadHandler.post { callback(logs) }
        }
    }

    override fun removeLogs() {
        executorService.execute {
            logDao.nukeTable()
        }
    }
}