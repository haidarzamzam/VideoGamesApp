package com.haidev.videogamesapp.view

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.haidev.videogamesapp.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class VideoGamesActivityInstrumentTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(VideoGamesActivity::class.java)

    @Test
    fun testRecyclerView() {
        onView(withId(R.id.rv_video_games))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_video_games))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
        onView(withId(R.id.rv_video_games))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(2))
    }
}