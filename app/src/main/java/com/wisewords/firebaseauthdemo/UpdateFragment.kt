package com.wisewords.firebaseauthdemo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.FirebaseDatabase
import com.wisewords.firebaseauthdemo.databinding.FragmentUpdateBinding
import com.wisewords.firebaseauthdemo.modal.Army

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

        binding.etId.setText(sp.getString("id", "")?: "")
        binding.etshowFirstName.setText(sp.getString("firstName", "") ?: "" )
        binding.etshowLastName.setText(sp.getString("lastName", "") ?: "")
        binding.etshowEmail.setText (sp.getString("email", "") ?: "")
        binding.etshowPassword.setText(sp.getString("password", "") ?: "")
        binding.etshowPassword1.setText(sp.getString("password1", "") ?: "")

        binding.btnUpdate.setOnClickListener {
            updateMyAramy(binding.etId.text.toString(),binding.etshowFirstName.text.toString(), binding.etshowLastName.text.toString(), binding.etshowEmail.text.toString(), binding.etshowPassword.text.toString(), binding.etshowPassword1.text.toString())
        }

        binding.btnDelete.setOnClickListener {
            deleteMyArmy(binding.etId.text.toString())
        }

        return binding.root
    }

    private fun deleteMyArmy(id: String) {
        val dbRef = FirebaseDatabase.getInstance().getReference("Army").child(id)
        val mTask = dbRef.removeValue()
        mTask.addOnCompleteListener {
            Toast.makeText(context, "Army deleted", Toast.LENGTH_LONG).show()
            findNavController().navigate(
                R.id.action_updateFragment_to_loggedUserFragment
            )
        }.addOnFailureListener{
            Toast.makeText(context, "Army deletion failed", Toast.LENGTH_LONG).show()
            findNavController().navigate(
                R.id.action_updateFragment_self
            )
        }

    }

    private fun updateMyAramy(id: String, firstName: String, lastName: String, emai:String, pass: String, pass1: String) {
        val dbRef = FirebaseDatabase.getInstance().getReference("Army").child(id)
        val armyInfo = Army(id, firstName, lastName, emai, pass, pass1)
        dbRef.setValue(armyInfo)
        Toast.makeText(context, "Updated", Toast.LENGTH_LONG).show()
    }


    /*
    Lets see it, bro IMP

fun openUpdateDialog(armyId: String, armyName: String){
    val mDialog = AlertDialog.Builder(this)
    val inflator = layoutInflater
    val mDialogView= inflator.inflate(R.layout..., null)

    mDialog.setView(mDialogView)

    settiing the valies to edittext
    val etFirstName = mDialog.findViewById<EditText>(R.id.fristname)

    val alertDialog = mDialog.create()
    alertDialog.show()

    btnUpdate.setOnClickListener{
        updateMyArmy(...)

    out the dialog, update the view edittext

    alertDialog.dismiss()
    }

}
     */


}