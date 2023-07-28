package com.wisewords.firebaseauthdemo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.wisewords.firebaseauthdemo.databinding.FragmentLoggedUserBinding
import com.wisewords.firebaseauthdemo.databinding.FragmentLoginBinding

class LoggedUserFragment : Fragment() {
    private lateinit var binding: FragmentLoggedUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoggedUserBinding.inflate(inflater,container, false)
        return binding.root
    }

}