package com.example.espressotesting

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Exception

@RunWith(AndroidJUnit4::class)
class MainActivityTest : TestCase(){

    @Rule @JvmField
    var activityRule = ActivityTestRule<MainActivity>(
        MainActivity::class.java
    )

    var str = "Hello World String"

    @Test
    @Throws(Exception::class)
    fun changeText_sameActivity(){
        onView(withId(R.id.edit_text))
            .perform(typeText(str), closeSoftKeyboard())
            onView(withId(R.id.button_click)).perform(click())


        //Check that the text was changed
        onView(withId(R.id.text_view))
            .check(matches(withText(str)))
    }
}