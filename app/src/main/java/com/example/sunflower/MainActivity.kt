package com.example.sunflower

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.sunflower.Adapter.ViewPager2Adapter
import com.example.sunflower.Fragment.MyGardenFragment
import com.example.sunflower.Fragment.PlantListFragment
import com.example.sunflower.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

/*
      * 1.binding.vpViewpagerMain.apply {
            adapter = viewPager2Adatper

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }
        -> 코드는 왜 여기에 넣었는지 설명할줄은 알아야 한다
      * */
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewPager()

    }

    private fun initViewPager() {
        //ViewPager2 Adapter 셋팅
        val viewPager2Adatper = ViewPager2Adapter(this)
        viewPager2Adatper.addFragment(MyGardenFragment())
        viewPager2Adatper.addFragment(PlantListFragment())

        //Adapter 연결
        binding.vpViewpagerMain.apply {
            adapter = viewPager2Adatper

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }

        //ViewPager, TabLayout 연결
        TabLayoutMediator(binding.tlNavigationView, binding.vpViewpagerMain) { tab, position ->
//            Log.e("YMC", "ViewPager position: ${position}")
            when (position) {
                0 -> tab.text = "MY GARDEN"
                1 -> tab.text = "PLANT LIST"
            }
        }.attach()
    }


}