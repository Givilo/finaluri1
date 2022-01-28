package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var email:EditText
    private lateinit var password : EditText
    private lateinit var loginButton : Button
    private lateinit var registration : Button
    private lateinit var resetPassword : Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        listener()


    }

    private fun init(){
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginButton)
        registration = findViewById(R.id.registration)
        resetPassword = findViewById(R.id.resetPassword)


    }

    private fun listener(){
        registration.setOnClickListener {
            startActivity(Intent(this,RegistartionActivity::class.java))

        }
        resetPassword.setOnClickListener {
            startActivity(Intent(this,resetPasswordActivity::class.java))
        }


        loginButton.setOnClickListener {
            
            
            val emailAddress = email.text.toString()
            val password = password.text.toString()
            
            if (emailAddress.isEmpty()|| password.isEmpty()){
                Toast.makeText(this, "ტიკტოკერი ხოარხარ შენ?", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(emailAddress,password)
                .addOnCompleteListener { vaja ->
                    if (vaja.isSuccessful){
                        startActivity(Intent(this,CalculatorActivity::class.java))
                        Toast.makeText(this, "შეგვიძლია ვიცეკვოთ!!!", Toast.LENGTH_SHORT).show()
                    }else {
                        Toast.makeText(this, "რაღაც შეცდომაა!", Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }
}