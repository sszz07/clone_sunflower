package com.example.sunflower.Fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sunflower.Adapter.PlantListAdapter
import com.example.sunflower.model.DBHelperFisrt
import com.example.sunflower.viewmodel.DataViewModel
import com.example.sunflower.PlantList
import com.example.sunflower.R
import com.example.sunflower.model.DBHelper
import kotlinx.coroutines.DelicateCoroutinesApi


/*
 * 1.변경되지 않는 값은 var-> val 변경
 * 2.클래스와 변수명 헷갈리지 않게 변수명은 소문자로 시작 / 클래스는 대문자로 시작
 * 3.코드 종료시 코들 정렬하기
 * */
class PlantListFragment : Fragment() {
    lateinit var model: DataViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_plant_list, container, false)
    }


    @OptIn(DelicateCoroutinesApi::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //var -> val 변경
        val rv_plant_list_fragment = view.findViewById<RecyclerView>(R.id.rv_plant_list_fragment)
        rv_plant_list_fragment.layoutManager = GridLayoutManager(context, 2)
        rv_plant_list_fragment.setHasFixedSize(true)
        rv_plant_list_fragment.adapter =
            PlantListAdapter(getFirstGarden(), "PlantListFragment")
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        val dbHelper = DBHelperFisrt(context, "FirstGarden.db", null, 1)
        model = ViewModelProvider(requireActivity()).get(DataViewModel::class.java)
        model.getData(dbHelper)
    }


    fun getFirstGarden(): ArrayList<PlantList> {
        val plantList = ArrayList<PlantList>()
        for (i: Int in 0..model.data.value!!.size - 1) {
            val fruit_image = model.data.value!!.get(i).fruitImage
            val fruit_name = model.data.value!!.get(i).fruitName
            val fruit_content = model.data.value!!.get(i).fruitContent
            plantList.add(i, PlantList(fruit_image, fruit_name, fruit_content))
        }
        return plantList
    }

}