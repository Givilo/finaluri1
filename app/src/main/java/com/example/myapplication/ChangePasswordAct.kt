package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ChangePasswordAct : AppCompatActivity() {

    private lateinit var changePassword : EditText
    private lateinit var changePasswordButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)
        findView()
        clickListener()

    }

    private fun findView(){
        changePasswordButton = findViewById(R.id.changePasswordButton)
        changePassword = findViewById(R.id.ChangePassword)



    }
    private fun clickListener(){
        changePasswordButton.setOnClickListener {
            val newPass = changePassword.text.toString()

            if (newPass.isEmpty()){
                Toast.makeText(this, "ველი ცარიელია!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .currentUser
                ?.updatePassword(newPass)
                ?.addOnCompleteListener {ako ->
                    if (ako.isSuccessful) {
                        Toast.makeText(this, "პაროლი შეიცვალა", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "რაღაც შეცდომაა!", Toast.LENGTH_SHORT).show()
                    }
                }

        }

    }
}