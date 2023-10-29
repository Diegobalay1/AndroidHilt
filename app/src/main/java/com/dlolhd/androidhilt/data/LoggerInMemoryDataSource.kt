package com.dlolhd.androidhilt.data

import dagger.hilt.android.scopes.ActivityScoped
import java.util.LinkedList
import javax.inject.Inject

//@ActivityScoped
class LoggerInMemoryDataSource @Inject constructor() : LoggerDataSource {

    private val logs = LinkedList<Log>()

    override fun addLog(title: String, msg: String) {
        logs.addFirst(Log(title, msg, System.currentTimeMillis()))
    }

    override fun getAllLogs(callback: (List<Log>) -> Unit) {
        callback(logs)
    }

    override fun removeLogs() {
        logs.clear()
    }

}