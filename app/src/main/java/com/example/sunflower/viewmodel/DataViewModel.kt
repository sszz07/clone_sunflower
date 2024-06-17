package com.example.sunflower



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {
    private val mainRepository = Repository()

    //MutableLiveData<ArrayList<PlantList>>이거 어떤 의미인지 공부하기
    private val _data = MutableLiveData<ArrayList<PlantList>>()
    val data: LiveData<ArrayList<PlantList>> = _data
    fun getData(dbHelperFisrt: DBHelperFisrt) {
        _data.value = mainRepository.getFirstGarden(dbHelperFisrt)
    }
}