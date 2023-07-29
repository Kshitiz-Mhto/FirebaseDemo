package com.wisewords.firebaseauthdemo

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.wisewords.firebaseauthdemo.databinding.FragmentLoggedUserBinding
import com.wisewords.firebaseauthdemo.databinding.FragmentLoginBinding
import com.wisewords.firebaseauthdemo.modal.Army
import com.wisewords.firebaseauthdemo.modal.RecylerViewAdaptor

class LoggedUserFragment : Fragment() {
    private lateinit var binding: FragmentLoggedUserBinding
    private lateinit var armyList: ArrayList<Army>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoggedUserBinding.inflate(inflater,container, false)

        val recyclerView = binding.myrecylerview
        recyclerView.setBackgroundColor(Color.TRANSPARENT)
        recyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )

        armyList = arrayListOf<Army>()

        dbRef = FirebaseDatabase.getInstance().getReference("Army")
        dbRef.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                armyList.clear()
                if (snapshot.exists()){
                    for(armySnap in snapshot.children){
                        val armyData = armySnap.getValue(Army::class.java)
                        armyList.add(armyData!!)
                    }
                    Log.i("army", armyList.toString())
                    recyclerView.adapter = RecylerViewAdaptor(armyList.toList(), context!!)
                }
                recyclerView.adapter = RecylerViewAdaptor(armyList.toList(), context!!)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        return binding.root
    }

}