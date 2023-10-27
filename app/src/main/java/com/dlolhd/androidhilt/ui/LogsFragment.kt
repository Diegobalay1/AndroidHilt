package com.dlolhd.androidhilt.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.dlolhd.androidhilt.AndroidHiltApplication
import com.dlolhd.androidhilt.R
import com.dlolhd.androidhilt.data.Log
import com.dlolhd.androidhilt.data.LoggerLocalDataSource
import com.dlolhd.androidhilt.util.DateFormatter

/**
 * Fragment that displays the database logs.
 */
class LogsFragment : Fragment() {

    private lateinit var logger: LoggerLocalDataSource
    private lateinit var dateFormatter: DateFormatter

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_logs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById<RecyclerView?>(R.id.recycler_view).apply {
            setHasFixedSize(true)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        populateFields(context)
    }

    private fun populateFields(context: Context) {
        logger = (context.applicationContext as AndroidHiltApplication)
            .appContainer.loggerDataSource
        dateFormatter =
            (context.applicationContext as AndroidHiltApplication)
                .appContainer.provideDateFormatter()
    }

    override fun onResume() {
        super.onResume()

        logger.getAllLogs { logs ->
            recyclerView.adapter =
                LogsViewAdapter(
                    logs,
                    dateFormatter
                )
        }
    }

}

private class LogsViewAdapter(
    private val logsDateSet: List<Log>,
    private val dateFormatter: DateFormatter
) : RecyclerView.Adapter<LogsViewAdapter.LogsViewHolder>() {
    class LogsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val description: TextView
        val img: ImageView

        init {
            title = view.findViewById(R.id.Title)
            description = view.findViewById(R.id.Subtitle)
            img = view.findViewById(R.id.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)

        return LogsViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: LogsViewHolder, position: Int) {
        val log = logsDateSet[position]
        holder.title.text = log.title
        holder.description.text = "${log.msg}\n\t${dateFormatter.formatDate(log.timestamp)}"
    }

    override fun getItemCount() = logsDateSet.size

}












