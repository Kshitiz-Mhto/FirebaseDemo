package com.wisewords.firebaseauthdemo

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RegistrationTest {

//    @JvmField
//    @Rule
//    val mPermissionsRule = GrantPermissionRule.grant(WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE)

    @JvmField
    @Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun moveToSignUp(){
        loginRobot {
            signUp()
        }
    }

    @Test
    fun testSuccessfullRegistrationWithOptions(){
        registrationRobotSignup {
            firstName("iberg")
            lastName("x00")
            email("x@gmail.com")
            pass1("4321")
            pass2("4321")
            chkRobotOptIn()
            register()
        }

    }

}