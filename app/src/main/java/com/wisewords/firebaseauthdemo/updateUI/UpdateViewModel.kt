package com.wisewords.firebaseauthdemo.updateUI

import android.content.Context
import androidx.lifecycle.ViewModel

class UpdateViewModel(val context: Context, val id: String, val firstName: String, val lastName: String, val email: String, val pass: String, val pass1: String): ViewModel() {

    var modelId =id
    var modelFirst = firstName
    var modelLast = lastName
    var modelEmail = email
    var modelPass = pass
    var modelPass1 = pass1


}