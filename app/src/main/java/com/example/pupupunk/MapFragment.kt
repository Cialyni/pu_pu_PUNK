package com.example.pupupunk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController


class MapFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        val btn_area = view.findViewById<Button>(R.id.button_12)
        btn_area.setOnClickListener{
            val navController = view.findNavController() // получаем ссылку на контроллер
            navController.navigate(R.id.MoveToArea)
        }

        return view
    }


}