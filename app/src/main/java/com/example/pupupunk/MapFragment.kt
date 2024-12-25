package com.example.pupupunk

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.navigation.findNavController


class MapFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        val bundle = Bundle()
        val btn_10 = view.findViewById<ImageButton>(R.id.imageButton10)
        val btn_12 = view.findViewById<ImageButton>(R.id.imageButton12)
        val btn_13 = view.findViewById<ImageButton>(R.id.imageButton13)
        val btn_14 = view.findViewById<ImageButton>(R.id.imageButton14)
        val btn_15 = view.findViewById<ImageButton>(R.id.imageButton15)
        val btn_16 = view.findViewById<ImageButton>(R.id.imageButton16)
        val btn_clumba = view.findViewById<ImageButton>(R.id.imageButtonClumba)
        val btn_20 = view.findViewById<ImageButton>(R.id.imageButton20)
        val btn_21 = view.findViewById<ImageButton>(R.id.imageButton21)
        val btn_22= view.findViewById<ImageButton>(R.id.imageButton22)
        val btn_23 = view.findViewById<ImageButton>(R.id.imageButton23)
        val btn_pool = view.findViewById<ImageButton>(R.id.imageButtonPool)
        val btn_left_field= view.findViewById<Button>(R.id.buttonLeftField)
        val btn_right_field = view.findViewById<Button>(R.id.buttonRightField)
        val btn_shaiba = view.findViewById<ImageButton>(R.id.imageButtonShaiba)
        val btn_profile = view.findViewById<ImageButton>(R.id.profile)
        btn_profile.setOnClickListener{
            val navController = view.findNavController() // получаем ссылку на контроллер
            navController.navigate(R.id.action_mapFragment_to_profileFragment)
        }
        btn_10.setOnClickListener{
            val area = "Location: 10 dormitory"
            bundle.putString("Area", area)
            val navController = view.findNavController() // получаем ссылку на контроллер
            navController.navigate(R.id.action_mapFragment_to_areaViewFragment, bundle)
        }
        btn_12.setOnClickListener{
            val area = "Location: 12 dormitory"
            bundle.putString("Area", area)
            val navController = view.findNavController() // получаем ссылку на контроллер
            navController.navigate(R.id.action_mapFragment_to_areaViewFragment, bundle)
        }
        btn_13.setOnClickListener{
            val area = "Location: 13 dormitory"
            bundle.putString("Area", area)
            val navController = view.findNavController() // получаем ссылку на контроллер
            navController.navigate(R.id.action_mapFragment_to_areaViewFragment, bundle)
        }
        btn_14.setOnClickListener{
            val area = "Location: 14 dormitory"
            bundle.putString("Area", area)
            val navController = view.findNavController() // получаем ссылку на контроллер
            navController.navigate(R.id.action_mapFragment_to_areaViewFragment, bundle)
        }
        btn_15.setOnClickListener{
            val area = "Location: 15 dormitory"
            bundle.putString("Area", area)
            val navController = view.findNavController() // получаем ссылку на контроллер
            navController.navigate(R.id.action_mapFragment_to_areaViewFragment, bundle)
        }
        btn_16.setOnClickListener{
            val area = "Location: 16 dormitory"
            bundle.putString("Area", area)
            val navController = view.findNavController() // получаем ссылку на контроллер
            navController.navigate(R.id.action_mapFragment_to_areaViewFragment, bundle)
        }
        btn_20.setOnClickListener{
            val area = "Location: 20 dormitory"
            bundle.putString("Area", area)
            val navController = view.findNavController() // получаем ссылку на контроллер
            navController.navigate(R.id.action_mapFragment_to_areaViewFragment, bundle)
        }
        btn_21.setOnClickListener{
            val area = "Location: 21 dormitory"
            bundle.putString("Area", area)
            val navController = view.findNavController() // получаем ссылку на контроллер
            navController.navigate(R.id.action_mapFragment_to_areaViewFragment, bundle)
        }
        btn_22.setOnClickListener{
            val area = "Location: 22 dormitory"
            bundle.putString("Area", area)
            val navController = view.findNavController() // получаем ссылку на контроллер
            navController.navigate(R.id.action_mapFragment_to_areaViewFragment, bundle)
        }
        btn_23.setOnClickListener{
            val area = "Location: 23 dormitory"
            bundle.putString("Area", area)
            val navController = view.findNavController() // получаем ссылку на контроллер
            navController.navigate(R.id.action_mapFragment_to_areaViewFragment, bundle)
        }
        btn_pool.setOnClickListener{
            val area = "Location: Billiard room"
            bundle.putString("Area", area)
            val navController = view.findNavController() // получаем ссылку на контроллер
            navController.navigate(R.id.action_mapFragment_to_areaViewFragment, bundle)
        }
        btn_shaiba.setOnClickListener{
            val area = "Location: Shaiba"
            bundle.putString("Area", area)
            val navController = view.findNavController() // получаем ссылку на контроллер
            navController.navigate(R.id.action_mapFragment_to_areaViewFragment, bundle)
        }
        btn_clumba.setOnClickListener{
            val area = "Location: Central Park"
            bundle.putString("Area", area)
            val navController = view.findNavController() // получаем ссылку на контроллер
            navController.navigate(R.id.action_mapFragment_to_areaViewFragment, bundle)
        }
        btn_left_field.setOnClickListener{
            val area = "Location: Left sport field"
            bundle.putString("Area", area)
            val navController = view.findNavController() // получаем ссылку на контроллер
            navController.navigate(R.id.action_mapFragment_to_areaViewFragment, bundle)
        }

        btn_right_field.setOnClickListener{
            val area = "Location: Right sport field"
            bundle.putString("Area", area)
            val navController = view.findNavController() // получаем ссылку на контроллер
            navController.navigate(R.id.action_mapFragment_to_areaViewFragment, bundle)
        }
        return view
    }


}