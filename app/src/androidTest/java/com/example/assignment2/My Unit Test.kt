package com.example.assignment2


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test

class MyUnitTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testStartButtonClick() {
        onView(withId(R.id.startButton)).perform(click())

        // Add assertions here to check the expected behavior after clicking the start button
    }

    @Test
    fun testFeedButtonClick() {
        onView(withId(R.id.feedButton)).perform(click())

        // Add assertions here to check the expected behavior after clicking the feed button
    }

    @Test
    fun testCleanButtonClick() {
        onView(withId(R.id.cleanButton)).perform(click())

        // Add assertions here to check the expected behavior after clicking the clean button
    }

    @Test
    fun testPlayButtonClick() {
        // Assuming this test is for activity_game.xml
        onView(withId(R.id.playButton)).perform(click())

        // Add assertions here to check the expected behavior after clicking the play button
    }
}
