package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class resetPasswordActivity : AppCompatActivity() {
    private lateinit var email : EditText
    private lateinit var resetPasswordButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        guramiko()
        resetPassListener()

    }

    private fun guramiko(){
        email = findViewById(R.id.email)
        resetPasswordButton = findViewById(R.id.resetPasswordButton)
    }


    private fun resetPassListener(){
        resetPasswordButton.setOnClickListener {
            val email = email.text.toString()
            
            if (email.isEmpty()){
                Toast.makeText(this , "ცარიელია!", Toast.LENGTH_SHORT).show()
            }
            FirebaseAuth.getInstance()
                .sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(this, "ლინკი გამოგზავნილია!", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "ასეთი ელ-ფოსტა არ არსებობს", Toast.LENGTH_SHORT).show()
                    }
                }

        }

    }
}