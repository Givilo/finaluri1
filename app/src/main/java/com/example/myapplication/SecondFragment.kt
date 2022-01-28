package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SecondFragment: Fragment(R.layout.fragment_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val image = view.findViewById<ImageView>(R.id.image)
        val name = view.findViewById<TextView>(R.id.name)
        val photo = view.findViewById<EditText>(R.id.photo)
        val userName = view.findViewById<EditText>(R.id.userName)
        val saveBtn = view.findViewById<Button>(R.id.saveBtn)
        val changePassword = view.findViewById<Button>(R.id.ChangePassword)
        val logout = view.findViewById<Button>(R.id.logout)
        val dataBase = FirebaseDatabase.getInstance().getReference("userInfo")
        val authentication = FirebaseAuth.getInstance()



        dataBase.child(authentication.currentUser?.uid!!).addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val info: UserInfoClass = snapshot.getValue(UserInfoClass::class.java) ?: return
                name.text = info.userName
                Glide.with(this@SecondFragment)
                    .load(info.imageUrl).placeholder(R.drawable.ic_launcher_foreground).into(image)

            }

            override fun onCancelled(error: DatabaseError) {
            }

        })



        saveBtn.setOnClickListener {
            val userName = userName.text.toString()
            val photo = photo.text.toString()

            if (userName.isEmpty()|| photo.isEmpty()){
                Toast.makeText(this.context, "რამე მაინც ჩაგეწერა!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val info = UserInfoClass(userName,photo)
            dataBase.child(authentication.currentUser?.uid!!).setValue(info)

        }

        logout.setOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
            requireActivity().finish()
        }
        changePassword.setOnClickListener {
            startActivity(Intent(requireContext(), ChangePasswordAct::class.java))
            requireActivity().finish()
        }

    }
}