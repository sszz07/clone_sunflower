package com.example.sunflower

import android.annotation.SuppressLint


//싱글톤으로 디비 클래스 만듬
class Repository {
    @SuppressLint("Range", "Recycle")
    fun getFirstGarden(dbHelperFisrt: DBHelperFisrt): ArrayList<PlantList> {
        val db = dbHelperFisrt.readableDatabase
        val cursor = db.rawQuery("SELECT name,content,image FROM first_plant", null)

        //데이터 담을 리스트
        val plantList = ArrayList<PlantList>()
        var i = 0
        //while true 였을때 계속 반복
        while (cursor.moveToNext()) {
            val fruit_name = cursor.getString(cursor.getColumnIndex("name"))
            val fruit_content = cursor.getString(cursor.getColumnIndex("content"))
            val fruit_image = cursor.getString(cursor.getColumnIndex("image"))
            plantList.add(i, PlantList(fruit_image, fruit_name, fruit_content))
            i++
        }
        return plantList
    }
}