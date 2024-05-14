package com.example.sunflower

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PlantListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plant_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var rv_plant_list_fragment = view.findViewById<RecyclerView>(R.id.rv_plant_list_fragment)
        println(rv_plant_list_fragment)

        var profilesList = arrayListOf(
            PlantList(R.drawable.apple,"apple"),
            PlantList(R.drawable.banana,"banana"),
            PlantList(R.drawable.grape,"grape"),
            PlantList(R.drawable.kiwi,"kiwi"),
            PlantList(R.drawable.orange,"orange"),
            PlantList(R.drawable.peach,"peach"),
            PlantList(R.drawable.strawberry,"strawberry"),
            PlantList(R.drawable.watermelon,"watermelon")

        )

        rv_plant_list_fragment.layoutManager = GridLayoutManager(context,2)
        rv_plant_list_fragment.setHasFixedSize(true)
        rv_plant_list_fragment.adapter = PlantListAdapter(profilesList)

    }
}