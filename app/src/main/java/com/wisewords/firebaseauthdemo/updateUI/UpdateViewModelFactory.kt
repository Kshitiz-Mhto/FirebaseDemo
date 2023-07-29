package com.wisewords.firebaseauthdemo.updateUI

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UpdateViewModelFactory(val context: Context, val id: String, val firstName: String, val lastName: String, val email: String, val pass: String, val pass1: String): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UpdateViewModel(context, id, firstName, lastName,email, pass, pass1) as T
    }
}