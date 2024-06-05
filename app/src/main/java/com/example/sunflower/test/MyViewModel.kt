package com.example.sunflower.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    //모르는 메소드 MutableLiveData,LiveData
    private val _data = MutableLiveData<String>()

    // 외부에서 data접근을 위해 데이터를 담아 놓는 홀더인 LiveData
    val data: LiveData<String> get() = _data

    // 뷰모델 안에서 데이터를 갱신하기 위한 함수
    fun updateData(newData: String) {
        _data.value = newData
    }
}