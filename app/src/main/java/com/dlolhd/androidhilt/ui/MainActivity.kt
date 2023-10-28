package com.dlolhd.androidhilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.dlolhd.androidhilt.AndroidHiltApplication
import com.dlolhd.androidhilt.R
import com.dlolhd.androidhilt.navigator.AppNavigator
import com.dlolhd.androidhilt.navigator.Screens
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //private lateinit var navigator: AppNavigator
    @Inject lateinit var navigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //navigator = (applicationContext as AndroidHiltApplication).appContainer.provideNavigator(this)

        if (savedInstanceState == null) {
            navigator.navigateTo(Screens.BUTTONS)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        }
    }

}