package com.example.sunflower.viewmodel



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sunflower.PlantList
import com.example.sunflower.model.DBHelper
import com.example.sunflower.model.DBHelperFisrt
import com.example.sunflower.model.Repository

class DataViewModel : ViewModel() {
    private val mainRepository = Repository()
    //MutableLiveData<ArrayList<PlantList>>이거 어떤 의미인지 공부하기
    private val _data = MutableLiveData<ArrayList<PlantList>>()
    val data: LiveData<ArrayList<PlantList>> = _data
    fun getData(dbHelperFisrt: DBHelperFisrt) {
        _data.value = mainRepository.getFirstGarden(dbHelperFisrt)
    }

    private val _myData = MutableLiveData<ArrayList<PlantList>>()
    val myData: LiveData<ArrayList<PlantList>> = _myData

    fun getMyData(dbHelper: DBHelper) {
        _myData.value = mainRepository.selectPlant(dbHelper)
    }
}