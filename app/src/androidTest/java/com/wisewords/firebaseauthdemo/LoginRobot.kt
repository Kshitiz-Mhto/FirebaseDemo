package com.wisewords.firebaseauthdemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId

fun loginRobot(func: LoginRobot.() -> Unit) = LoginRobot().apply(func)

class LoginRobot {

    fun fillEmail(email:String): LoginRobot{
        onView(USER_EMAIL_MATCHER).perform(clearText(), typeText(email), closeSoftKeyboard())
        return this
    }
    fun fillPassword(pass: String): LoginRobot{
        onView(USER_PASSWORD_MATCHER).perform(clearText(), typeText(pass), closeSoftKeyboard())
        return this
    }

    fun login(): LoginRobot{
        onView(USER_LOGIN_BUTTON).perform(click())
        return this
    }

    fun signUp(): LoginRobot{
        onView(USER_SIGNUP_BUTTON).perform(click())
        return this
    }

    companion object{
        private val USER_EMAIL_MATCHER = withId(R.id.etEmail)
        private val USER_PASSWORD_MATCHER = withId(R.id.etPassword)
        private val USER_LOGIN_BUTTON = withId(R.id.btnLogin)
        private val USER_SIGNUP_BUTTON = withId(R.id.btnSignup)
    }

}