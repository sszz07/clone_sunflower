package com.example.sunflower.test

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sunflower.R
import com.example.sunflower.databinding.ActivityMainBinding
//class MainActivityTestMvvm : AppCompatActivity() {
//    private lateinit var viewModel: MyViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main_test_mvvm)
//
//        val bt = findViewById<Button>(R.id.bt)
//        val et = findViewById<EditText>(R.id.et)
//        val tv = findViewById<TextView>(R.id.tv)
//
//        //뷰모델 초기화
//        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
//
//        //옵저버를 이용해서 변화를 감지한다
//        viewModel.data.observe(this, Observer { newData ->
//            //새로운 데이터를 이용해서 UI변경!
//            tv.text = newData
//        })
//
//        // Trigger an update (for example, when a button is clicked)
//        bt.setOnClickListener {
//            val newData = et.text.toString()
//            viewModel.updateData(newData)
//        }
//    }
//}

//모른느것 observe,ViewModelProvider,newData,lateinit