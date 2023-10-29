package com.dlolhd.androidhilt.data

// Common interface for Logger data sources.
interface LoggerDataSource {
    fun addLog(title: String, msg: String)
    fun getAllLogs(callback: (List<Log>) -> Unit)
    fun removeLogs()
}