package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment


class FirstFragment : Fragment(R.layout.fragment_first){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val firstInput = view.findViewById<EditText>(R.id.first_input)
        val secondInput = view.findViewById<EditText>(R.id.second_input)
        val additionBtn = view.findViewById<Button>(R.id.addition_btn)
        val subtraction_btn = view.findViewById<Button>(R.id.subtraction_btn)
        val multiplication_btn = view.findViewById<Button>(R.id.multiplication_btn)
        val division_btn = view.findViewById<Button>(R.id.division_btn)
        val resultLabel = view.findViewById<TextView>(R.id.result_label)

        additionBtn.setOnClickListener {

            resultLabel.text = "Result:"+ (firstInput.text.toString().toFloat()+secondInput.text.toString().toFloat()).toString()



        }
        subtraction_btn.setOnClickListener {
            resultLabel.text = "Result:"+(firstInput.text.toString().toFloat()-secondInput.text.toString().toFloat()).toString()
        }
        multiplication_btn.setOnClickListener {
            resultLabel.text = "Result:"+(firstInput.text.toString().toFloat()*secondInput.text.toString().toFloat()).toString()
        }
        division_btn.setOnClickListener {
            resultLabel.text = "Result:"+(firstInput.text.toString().toFloat()/secondInput.text.toString().toFloat()).toString()
        }
    }





    }
















