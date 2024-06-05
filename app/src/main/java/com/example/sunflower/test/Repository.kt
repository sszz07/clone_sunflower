package com.example.sunflower

import android.annotation.SuppressLint
import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

//싱글톤으로 디비 클래스 만듬
object Repository {
    val dbHelper = DBHelper(context = null, "MyGarden.db", null, 1)
    val dbWrite = dbHelper.writableDatabase
    val dbRead = dbHelper.readableDatabase




    @SuppressLint("Range")
    fun getData(plantData : LiveData<ArrayList<PlantList>>) {
        val cursor = dbRead.rawQuery(
            "SELECT fruit_name,fruit_content,fruit_image FROM my_garden",
            null
        )
        //데이터 담을 리스트
        var i = 0
        //while true 였을때 계속 반복


        while (cursor.moveToNext()) {
            val fruitName = cursor.getString(cursor.getColumnIndex("fruit_name"))
            val fruitContent = cursor.getString(cursor.getColumnIndex("fruit_content"))
            val fruitImage = cursor.getInt(cursor.getColumnIndex("fruit_image"))
            plantData.value?.add(i, PlantList(fruitImage, fruitName, fruitContent))
            i++
        }
    }
}