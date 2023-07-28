package com.wisewords.firebaseauthdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.wisewords.firebaseauthdemo.databinding.FragmentSignupBinding
import com.wisewords.firebaseauthdemo.modal.Army

class SignupFragment : Fragment() {

    private lateinit var dbRef: DatabaseReference

    private lateinit var binding: FragmentSignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSignupBinding.inflate(inflater, container, false)
        dbRef = FirebaseDatabase.getInstance().getReference("Army")

        binding.btnSignup.setOnClickListener {
            saveMyArmy()
            findNavController().navigate(
                R.id.action_signupFragment_to_loginFragment
            )
        }

        binding.btnLoginFromSignUp.setOnClickListener {
            findNavController().navigate(
                R.id.action_signupFragment_to_loginFragment
            )
        }


        return binding.root
    }

    private fun saveMyArmy() {
        // getting the values

        val armyFirstName = binding.etFillFirstName.text.toString()
        val armyLastName = binding.etFillLastName.text.toString()
        val armyEmail = binding.etFillEmail.text.toString()
        val armyPassword = binding.etFillPassword.text.toString()
        val armyPassword1 = binding.etPasswordAgain.text.toString()
        val armyPolicy = binding.chkAgreement.isChecked
        val armyRobot = binding.chkRobot.isChecked

        if (armyFirstName.isEmpty() or armyLastName.isEmpty()){
            binding.etFillLastName.error = "enter your fucking name"
            binding.etFillFirstName.error = "enter your fucking name"
        }

        if (armyEmail.isEmpty()){
            binding.etFillEmail.error = "enter your fucking email"
        }

        val armyId = dbRef.push().key!!
        val army = Army(armyId, armyFirstName,armyLastName, armyEmail, armyPassword, armyPassword1, armyPolicy, armyRobot)
        dbRef.child(armyId).setValue(army)
            .addOnCompleteListener {
                Toast.makeText(this.context, "data is inserted", Toast.LENGTH_LONG).show()
            }.addOnFailureListener{ err->
                Toast.makeText(this.context, "Error!!", Toast.LENGTH_LONG).show()

            }

    }

}