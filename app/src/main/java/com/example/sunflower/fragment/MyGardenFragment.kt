package com.example.sunflower.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sunflower.test.DataViewModel
import com.example.sunflower.R


class MyGardenFragment : Fragment() {
    val getMyGarden =  DataViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_garden, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        val rvPlantListFragment = view.findViewById<RecyclerView>(R.id.rv_my_garden_fragment)
//        val tvMyGarden = view.findViewById<TextView>(R.id.tv_my_garden)
//        val btMyGardenFragment = view.findViewById<Button>(R.id.bt_my_garden_fragment)
//
//        if (getMyGarden.getData().value?.size == 0) {
//            tvMyGarden.visibility = View.VISIBLE
//            btMyGardenFragment.visibility = View.VISIBLE
//        } else {
//            tvMyGarden.visibility = View.INVISIBLE
//            btMyGardenFragment.visibility = View.INVISIBLE
//        }
//
//
//        rvPlantListFragment.layoutManager = GridLayoutManager(context, 2)
//        rvPlantListFragment.setHasFixedSize(true)
//        rvPlantListFragment.adapter = PlantListAdapter(getMyGarden.getData(), "MyGardenFragment")

    }

//    override fun onStart() {
//        super.onStart()
//        val rvPlantListFragment = view?.findViewById<RecyclerView>(R.id.rv_my_garden_fragment)
//        val tvMyGarden = view?.findViewById<TextView>(R.id.tv_my_garden)
//        val btMyGardenFragment = view?.findViewById<Button>(R.id.bt_my_garden_fragment)
//        reLoad(rvPlantListFragment!!, tvMyGarden!!, btMyGardenFragment!!)
//
//
//        //Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type RecyclerView?->에러가 날수도 있음
//        //rv_plant_list_fragment.layoutManager = GridLayoutManager(context, 2)
//        //rv_plant_list_fragment.setHasFixedSize(true)
//        //rv_plant_list_fragment.adapter = PlantListAdapter(getMyGarden(), "MyGardenFragment")
//    }





//    fun reLoad(
//        rvPlantListFragment: RecyclerView,
//        tvMyGarden: TextView,
//        btMyGardenFragment: Button
//    ) {
//        if (getMyGarden.getData().value?.size == 0) {
//            tvMyGarden.visibility = View.VISIBLE
//            btMyGardenFragment.visibility = View.VISIBLE
//        } else {
//            tvMyGarden.visibility = View.INVISIBLE
//            btMyGardenFragment.visibility = View.INVISIBLE
//        }
//
//        rvPlantListFragment.layoutManager = GridLayoutManager(context, 2)
//        rvPlantListFragment.setHasFixedSize(true)
//        rvPlantListFragment.adapter = PlantListAdapter(getMyGarden.getData(), "MyGardenFragment")
//    }
}