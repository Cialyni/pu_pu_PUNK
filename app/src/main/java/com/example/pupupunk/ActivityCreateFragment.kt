package com.example.pupupunk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController

import androidx.recyclerview.widget.RecyclerView


class ActivityCreateFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_activity_create, container, false)
        val sumbitButton: Button = view.findViewById(R.id.submitButton)
        val edt1: EditText = view.findViewById(R.id.editText1)
        val edt2: EditText = view.findViewById(R.id.editText2)
        val edt3: EditText = view.findViewById(R.id.editText3)
        sumbitButton.setOnClickListener{
            val message = "$edt1 $edt2 $edt3"
            val action = ActivityCreateFragmentDirections
                .actionSubmitCreation(message)
            view.findNavController().navigate(action)
        }

        return view
    }

}