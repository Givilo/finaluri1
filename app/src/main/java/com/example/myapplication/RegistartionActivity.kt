package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegistartionActivity : AppCompatActivity() {

    private lateinit var email:EditText
    private lateinit var passwordEditText:EditText
    private lateinit var register:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registartion)
        jemali()
        listenerebi()

    }

    private fun jemali(){
        email = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.passwordEditText)
        register = findViewById(R.id.register)
    }

    private fun listenerebi(){
        register.setOnClickListener {
            val email = email.text.toString()
            val passwordEditText = passwordEditText.text.toString()

            if (email.isEmpty()|| passwordEditText.isEmpty()){
                Toast.makeText(this, "ველი ცარიელია!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email,passwordEditText)
                .addOnCompleteListener { guramiko ->
                    if (guramiko.isSuccessful){
                        startActivity(Intent(this,MainActivity::class.java))
                        Toast.makeText(this, "რეგისტრაცია წარმატებით დასრულდა", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                    }
                }

        }

    }
}