package com.wisewords.firebaseauthdemo

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginTest {

    @JvmField
    @Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun testingLoginUser(){
        loginRobot {
            fillEmail("x00@gmail.com")
            fillPassword("1234")
            login()
        }

    }

}