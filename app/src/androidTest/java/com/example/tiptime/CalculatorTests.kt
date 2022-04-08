package com.example.tiptime

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CalculatorTests {

    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_20_percent_tip() {
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.calculate_button))
            .perform(click())

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$10.00"))))
    }

    @Test
    fun calculate_18_percent_tip() {
        // Select the cost_of_service_edit_text View by Id and type 100.00 into it.
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("100.00"))
            .perform(ViewActions.closeSoftKeyboard())

        // Click the 18% radio button
        onView(withId(R.id.option_eighteen_percent))
            .perform(click())

        // Click the calculate button
        onView(withId(R.id.calculate_button))
            .perform(click())

        // check that the text in tip_result matches with "$18.00"
        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$18.00"))))
    }

}