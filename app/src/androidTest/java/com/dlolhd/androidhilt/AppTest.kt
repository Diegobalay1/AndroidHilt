package com.dlolhd.androidhilt

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dlolhd.androidhilt.data.LoggerDataSource
import com.dlolhd.androidhilt.ui.MainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.CoreMatchers.containsString
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class AppTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @After
    fun tearDown() {
        // Remove logs after the test finishes
        //AppContainer(getInstrumentation().targetContext).loggerLocalDataSource.removeLogs()
    }

    @Test
    fun happyPath() {
        ActivityScenario.launch(MainActivity::class.java)

        // Check Buttons fragment screen is displayed
        onView(withId(R.id.textView)).check(matches(isDisplayed()))

        // Tap on Button 1
        onView(withId(R.id.button1)).perform(click())

        // Navigate to Logs screen
        onView(withId(R.id.all_logs)).perform(click())

        // Check Logs fragment screen is displayed
        onView(withText(containsString("Interaction with 'Button 1'")))
            .check(matches(isDisplayed()))
    }

}