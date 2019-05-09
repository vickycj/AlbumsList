package com.vicky.apps.datapoints.ui.view

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ScrollToAction
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.runner.RunWith
import androidx.test.rule.ActivityTestRule
import com.vicky.apps.datapoints.R
import org.hamcrest.CoreMatchers.*
import org.hamcrest.Matchers.hasEntry
import org.junit.Before
import org.junit.Test


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest{
    private var stringval: String = ""
    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)


    @Before
    fun initValidString() {
        // Specify a valid string.
        stringval = "ab rerum non rerum consequatur"
    }

    @Test
    fun testingTheRecyclerView(){
        onData(allOf(`is`(instanceOf(Map::class.java)),
            hasEntry(equalTo(stringval),
                `is`("item: 0"))))
    }

    @Test
    fun testTheActivitySorted() {
        onView(allOf(withId(R.id.title), withText(stringval)))
    }


    @Test
    fun testTheScrollEvent(){
        onView(withId(R.id.title)).perform(ScrollToAction())
    }
}