package com.wisewords.firebaseauthdemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId

fun registrationRobotSignup(func: RegistrationRobot.() -> Unit) = RegistrationRobot().apply(func)

class RegistrationRobot {

    fun firstName (firstname: String): RegistrationRobot{
        onView(FRIST_NAME_INPUT_MATCHER).perform(clearText(),typeText(firstname), closeSoftKeyboard())
        return this
    }

    fun lastName( lastname: String): RegistrationRobot{
        onView(LAST_NAME_INPUT_MATCHER).perform(clearText(),typeText(lastname), closeSoftKeyboard())
        return this
    }

    fun email(email: String): RegistrationRobot{
        onView(EMAIL_INPUT_MATCHER).perform(clearText(), typeText(email), closeSoftKeyboard())
        return this
    }

    fun chkRobotOptIn(): RegistrationRobot{
        onView(I_AM_ROBOT_MATCHER).perform(click())
        return this
    }

    fun pass1(pass: String): RegistrationRobot{
        onView(PASS_MATCHER1).perform(clearText(), typeText(pass), closeSoftKeyboard())
        return this
    }

    fun pass2(pass: String): RegistrationRobot{
        onView(PASS_MATCHER2).perform(clearText(), typeText(pass), closeSoftKeyboard())
        return this
    }

    fun register(): RegistrationRobot{
        onView(REGISTER_USER_MATCHER).perform(click())
        return this
    }

    companion object{
        private val FRIST_NAME_INPUT_MATCHER = withId(R.id.etFillFirstName)
        private val LAST_NAME_INPUT_MATCHER = withId(R.id.etFillLastName)
        private val EMAIL_INPUT_MATCHER = withId(R.id.etFillEmail)
        private val I_AM_ROBOT_MATCHER = withId(R.id.chkRobot)
        private val REGISTER_USER_MATCHER = withId(R.id.btnSignup)
        private val PASS_MATCHER1 = withId(R.id.etFillPassword)
        private val PASS_MATCHER2 = withId(R.id.etPasswordAgain)
    }

}