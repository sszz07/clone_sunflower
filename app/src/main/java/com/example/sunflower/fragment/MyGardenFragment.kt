package com.example.sunflower.Fragment

import android.animation.Animator
import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sunflower.Adapter.PlantListAdapter
import com.example.sunflower.PlantList
import com.example.sunflower.R
import com.example.sunflower.model.DBHelper
import com.example.sunflower.model.DBHelperFisrt
import com.example.sunflower.viewmodel.DataViewModel


class MyGardenFragment : Fragment() {
    lateinit var model: DataViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_garden, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dbHelper()
        val rv_plant_list_fragment = view.findViewById<RecyclerView>(R.id.rv_my_garden_fragment)
        val tv_my_garden = view.findViewById<TextView>(R.id.tv_my_garden)
        val bt_my_garden_fragment = view.findViewById<Button>(R.id.bt_my_garden_fragment)

        if (getMyGarden().size == 0) {
            tv_my_garden.visibility = View.VISIBLE
            bt_my_garden_fragment.visibility = View.VISIBLE
        } else {
            tv_my_garden.visibility = View.INVISIBLE
            bt_my_garden_fragment.visibility = View.INVISIBLE
        }
        rv_plant_list_fragment.layoutManager = GridLayoutManager(context, 2)
        rv_plant_list_fragment.setHasFixedSize(true)
        rv_plant_list_fragment.adapter = PlantListAdapter(getMyGarden(), "MyGardenFragment")

    }


    //첫 실행했을때
    @SuppressLint("Range", "Recycle")
    fun getMyGarden(): ArrayList<PlantList> {
        val plantList = ArrayList<PlantList>()
        for (i: Int in 0..model.myData.value!!.size - 1) {
            val fruit_image = model.myData.value!!.get(i).fruitImage
            val fruit_name = model.myData.value!!.get(i).fruitName
            val fruit_content = model.myData.value!!.get(i).fruitContent
            plantList.add(i, PlantList(fruit_image, fruit_name, fruit_content))
        }
        return plantList
    }


    override fun onStart() {
        super.onStart()
        dbHelper()

        val rv_plant_list_fragment = view?.findViewById<RecyclerView>(R.id.rv_my_garden_fragment)
        val tv_my_garden = view?.findViewById<TextView>(R.id.tv_my_garden)
        val bt_my_garden_fragment = view?.findViewById<Button>(R.id.bt_my_garden_fragment)
        reLoad(rv_plant_list_fragment!!, tv_my_garden!!, bt_my_garden_fragment!!)
        //Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type RecyclerView?->에러가 날수도 있음
        //rv_plant_list_fragment.layoutManager = GridLayoutManager(context, 2)
        //rv_plant_list_fragment.setHasFixedSize(true)
        //rv_plant_list_fragment.adapter = PlantListAdapter(getMyGarden(), "MyGardenFragment")
    }


    fun reLoad(
        rv_plant_list_fragment: RecyclerView,
        tv_my_garden: TextView,
        bt_my_garden_fragment: Button
    ) {
        if (getMyGarden().size == 0) {
            tv_my_garden.visibility = View.VISIBLE
            bt_my_garden_fragment.visibility = View.VISIBLE
        } else {
            tv_my_garden.visibility = View.INVISIBLE
            bt_my_garden_fragment.visibility = View.INVISIBLE
        }
        rv_plant_list_fragment.layoutManager = GridLayoutManager(context, 2)
        rv_plant_list_fragment.setHasFixedSize(true)
        rv_plant_list_fragment.adapter = PlantListAdapter(getMyGarden(), "MyGardenFragment")
    }

    fun dbHelper(){
        val dbHelper = DBHelper(requireActivity(), "MyGarden.db", null, 1)
        model = ViewModelProvider(requireActivity()).get(DataViewModel::class.java)
        model.getMyData(dbHelper)
    }
}