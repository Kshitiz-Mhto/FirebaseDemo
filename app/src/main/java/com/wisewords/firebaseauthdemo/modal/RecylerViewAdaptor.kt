package com.wisewords.firebaseauthdemo.modal

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.wisewords.firebaseauthdemo.R

class RecylerViewAdaptor(val searchList: List<Army>?, val context: Context) : RecyclerView.Adapter<MyViewHolder>() {

    private lateinit var sp : SharedPreferences

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflator = LayoutInflater.from(parent.context)
        val listItem = layoutInflator.inflate(R.layout.list_card, parent, false)
        sp = parent.context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        return MyViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return searchList!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var index_element = searchList!![position]

        holder.myTextView.text = index_element.armyFirstName +"  "+ index_element.armyLastName

        holder.myTextView.setOnClickListener {
            val editor = sp.edit()
            editor.putString("id", index_element.armyId)
            editor.putString("firstName", index_element.armyFirstName)
            editor.putString("lastName", index_element.armyLastName)
            editor.putString("email", index_element.armyEmail)
            editor.putString("password", index_element.armyPassword)
            editor.putString("password1", index_element.armyPassword1)
            editor.apply()
            it.findNavController().navigate(
                R.id.action_loggedUserFragment_to_updateFragment
            )
        }
    }
}

class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){
    val myTextView = view.findViewById<TextView>(R.id.tvFood)
    val btnUpdate = view.findViewById<Button>(R.id.btnUpdate)
    val btnDelete = view.findViewById<Button>(R.id.btnDelete)
}
