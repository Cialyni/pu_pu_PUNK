package com.example.pupupunk

import CustomAdapter
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pupupunk.Model.ItemActivity
import com.tworoot2.sqlitedatabase.databaseClass.Domain


class AreaViewFragment : Fragment() {

    private lateinit var db: Domain
    lateinit var recycleData: ArrayList<ItemActivity>
    lateinit var adapter: CustomAdapter
    lateinit var activitiesList: RecyclerView



        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

            val view = inflater.inflate(R.layout.fragment_area_view, container, false)
            db = Domain(requireContext(), null)

            val createActivityButton: ImageButton = view.findViewById(R.id.button_create_activity)
            val labelLocation: TextView = view.findViewById(R.id.location)
            val locationName = arguments?.getString("Area")
            labelLocation.text = locationName
            db.clearAllDeadlines()
            activitiesList = view.findViewById(R.id.activityRecycle)
            activitiesList.layoutManager = LinearLayoutManager(view.context)
            recycleData = db.getData(locationName!!)
            Log.d("FIRSTCHECK", recycleData.size.toString())
            adapter = CustomAdapter(recycleData)
            activitiesList.adapter = adapter

            createActivityButton.setOnClickListener{
                showCreationForm(locationName)
            }
            return view


    }


    fun showCreationForm(locationName: String) {
        var alertDialog: AlertDialog
        val inflater: LayoutInflater = this.getLayoutInflater()
        val dialogView: View = inflater.inflate(R.layout.fragment_activity_create, null)
        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        dialogBuilder.setView(dialogView)
        alertDialog = dialogBuilder.create();

        val edtDescr = dialogView.findViewById<EditText>(R.id.editTextDescription)
        val edtPlace = dialogView.findViewById<EditText>(R.id.editTextPlace)
        val edtDate = dialogView.findViewById<EditText>(R.id.editTextDate)
        val edtTime = dialogView.findViewById<EditText>(R.id.editTextTime)
        val submitButton: Button = dialogView.findViewById(R.id.submitButton)

        submitButton.setOnClickListener {
            if (edtDescr.text.toString() != "" && edtPlace.text.toString() != "" &&
                edtDate.text.toString() != "" && edtTime.text.toString() != "") {
                try {
                    db.insertActivity(
                        locationName,
                        "Cialyni",
                        "app/src/main/res/drawable/avatar.png",
                        edtDescr.text.toString(),
                        edtPlace.text.toString(),
                        edtDate.text.toString(),
                        edtTime.text.toString(),
                    )
                    recycleData.clear()

                    recycleData = db.getData(locationName)
                    adapter = CustomAdapter(recycleData)
                    activitiesList.adapter = adapter
                    alertDialog.dismiss()
                    Toast.makeText(this.context, "Sending activity to database", Toast.LENGTH_LONG)
                        .show()
                }catch(e: Exception){
                    Log.d("InsertionError", e.toString())
                    Toast.makeText(this.context, e.message, Toast.LENGTH_LONG)
                        .show()
                }
            }
            else{
                Toast.makeText(this.context, "Enter all info", Toast.LENGTH_LONG).show()
            }
        }

        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.show()
    }




}