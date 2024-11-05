package com.example.pupupunk

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView



class AreaViewFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var cnt: Int = 0
        val view = inflater.inflate(R.layout.fragment_area_view, container, false)
        val createActivityButton: Button = view.findViewById(R.id.button_create_activity)
        var markbox: RecyclerView = view.findViewById(R.id.markBox)


        createActivityButton.setOnClickListener{

        }
        return view
    }


}