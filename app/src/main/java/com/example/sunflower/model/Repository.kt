package com.example.sunflower.model

import android.annotation.SuppressLint
import android.database.sqlite.SQLiteDatabase
import com.example.sunflower.PlantList


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

    fun insertPlant(dbHelper: DBHelper, name: String, content: String, image: String) {
        val db = dbHelper.writableDatabase
        dbHelper.insert(db, name, content, image)
    }

    @SuppressLint("Range")
    fun selectPlant(dbHelper: DBHelper): ArrayList<PlantList> {
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT fruit_name,fruit_content,fruit_image FROM my_garden", null)

        //데이터 담을 리스트
        val plantList = ArrayList<PlantList>()
        var i = 0
        //while true 였을때 계속 반복
        while (cursor.moveToNext()) {
            val fruit_name = cursor.getString(cursor.getColumnIndex("fruit_name"))
            val fruit_content = cursor.getString(cursor.getColumnIndex("fruit_content"))
            val fruit_image = cursor.getString(cursor.getColumnIndex("fruit_image"))
            plantList.add(i, PlantList(fruit_image, fruit_name, fruit_content))
            i++
        }
        return plantList
    }


    fun deletePlant(dbHelper: DBHelper, name: String) {
        val db = dbHelper.writableDatabase
        dbHelper.delete(db, name)
    }


    //select문
    //디비에 저장되어있는지 존재 여부 확인
    @SuppressLint("Range", "Recycle")
    fun select(db: SQLiteDatabase, fruitName: String): Int {
        val sql = " SELECT * FROM my_garden  WHERE fruit_name='${fruitName}'"
        val result = db.rawQuery(sql, null)

        if (result.getCount() > 0) {
            return result.getCount()
        } else {
            return 0
        }
    }
}
