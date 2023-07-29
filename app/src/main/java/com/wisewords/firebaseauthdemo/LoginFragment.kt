package com.wisewords.firebaseauthdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.wisewords.firebaseauthdemo.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.btnSignup.setOnClickListener {
            findNavController().navigate(
                R.id.action_loginFragment_to_signupFragment
            )
        }
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(
                R.id.action_loginFragment_to_loggedUserFragment
            )
        }

        return binding.root
    }
}