package com.dlolhd.androidhilt.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.dlolhd.androidhilt.AndroidHiltApplication
import com.dlolhd.androidhilt.R
import com.dlolhd.androidhilt.data.LoggerLocalDataSource
import com.dlolhd.androidhilt.navigator.AppNavigator
import com.dlolhd.androidhilt.navigator.Screens
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Fragment that displays buttons whose interactions are recorded.
 */
@AndroidEntryPoint
class ButtonsFragment : Fragment() {

    /*private lateinit var logger: LoggerLocalDataSource
    private lateinit var navigator: AppNavigator*/
    @Inject lateinit var logger: LoggerLocalDataSource
    @Inject lateinit var navigator: AppNavigator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_buttons, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.button1).setOnClickListener {
            logger.addLog("Logger 1", "Interaction with 'Button 1")
        }
        view.findViewById<Button>(R.id.button2).setOnClickListener {
            logger.addLog("Logger 2", "Interaction with 'Button 2")
        }
        view.findViewById<Button>(R.id.button3).setOnClickListener {
            logger.addLog("Logger 3", "Interaction with 'Button 3")
        }
        view.findViewById<Button>(R.id.all_logs).setOnClickListener {
            navigator.navigateTo(Screens.LOGS)
        }
        view.findViewById<Button>(R.id.delete_logs).setOnClickListener {
            logger.removeLogs()
        }
    }

    /*override fun onAttach(context: Context) {
        super.onAttach(context)

        populateFields(context)
    }

    private fun populateFields(context: Context) {
        logger = (context.applicationContext as AndroidHiltApplication)
            .appContainer.loggerDataSource
        navigator = (context.applicationContext as AndroidHiltApplication)
            .appContainer.provideNavigator(requireActivity())
    }*/

}