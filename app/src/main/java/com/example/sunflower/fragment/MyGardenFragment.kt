package com.example.sunflower.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sunflower.Adapter.PlantListAdapter
import com.example.sunflower.DBHelper
import com.example.sunflower.PlantList
import com.example.sunflower.R


class MyGardenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_garden, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

    override fun onStart() {
        super.onStart()
        val rv_plant_list_fragment = view?.findViewById<RecyclerView>(R.id.rv_my_garden_fragment)
        val tv_my_garden = view?.findViewById<TextView>(R.id.tv_my_garden)
        val bt_my_garden_fragment = view?.findViewById<Button>(R.id.bt_my_garden_fragment)
        reLoad(rv_plant_list_fragment!!, tv_my_garden!!, bt_my_garden_fragment!!)


        //Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type RecyclerView?->에러가 날수도 있음
        //rv_plant_list_fragment.layoutManager = GridLayoutManager(context, 2)
        //rv_plant_list_fragment.setHasFixedSize(true)
        //rv_plant_list_fragment.adapter = PlantListAdapter(getMyGarden(), "MyGardenFragment")
    }


    @SuppressLint("Range", "Recycle")
    fun getMyGarden(): ArrayList<PlantList> {
        var dbHelper = DBHelper(context, "MyGarden.db", null, 1)
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT fruit_name,fruit_content,fruit_image FROM my_garden", null)

        //데이터 담을 리스트
        val plantList = ArrayList<PlantList>()
        var i = 0
        //while true 였을때 계속 반복
        while (cursor.moveToNext()) {
            val fruit_name = cursor.getString(cursor.getColumnIndex("fruit_name"))
            val fruit_content = cursor.getString(cursor.getColumnIndex("fruit_content"))
            val fruit_image = cursor.getString(cursor.getColumnIndex("fruit_image"))
            plantList.add(i, PlantList(fruit_image, fruit_name, fruit_content))
            i++
        }
        return plantList
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
}