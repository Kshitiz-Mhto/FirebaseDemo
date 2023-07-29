package com.wisewords.firebaseauthdemo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.wisewords.firebaseauthdemo.databinding.FragmentUpdateBinding

class UpdateFragment : Fragment() {

    private lateinit var binding: FragmentUpdateBinding
    private lateinit var sp: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateBinding.inflate(inflater, container, false)
        sp =  requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        binding.etshowFirstName.text = sp.getString("firstName", "") ?: ""
        binding.etshowLastName.text = sp.getString("lastName", "") ?: ""
        binding.etshowEmail.text = sp.getString("email", "") ?: ""
        binding.etshowPassword.text = sp.getString("password", "") ?: ""
        binding.etshowPassword1.text = sp.getString("password1", "") ?: ""

        return binding.root
    }
}