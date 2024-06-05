package com.example.sunflower.fragment

import androidx.fragment.app.Fragment


/*
 * 1.변경되지 않는 값은 var-> val 변경
 * 2.클래스와 변수명 헷갈리지 않게 변수명은 소문자로 시작 / 클래스는 대문자로 시작
 * 3.코드 종료시 코들 정렬하기
 * */
class PlantListFragment : Fragment() {
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_plant_list, container, false)
//    }
//
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val plantList =  DataViewModel()
//
//
//        //var -> val 변경
//        val rvPlantListFragment = view.findViewById<RecyclerView>(R.id.rv_plant_list_fragment)
//
//
//
//        rvPlantListFragment.layoutManager = GridLayoutManager(context, 2)
//        rvPlantListFragment.setHasFixedSize(true)
//        rvPlantListFragment.adapter = PlantListAdapter(plantList.makeData(), "PlantListFragment")
//
//    }
}