package com.example.sunflower

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBHelperFisrt(
    context: Context?, //데이터베이스에 대한 경로를 찾는 데 사용합니다. 이 값은 null -> 해석 안드로이드에서 제공하는 api에 접근하기 위해 사용
    name: String?,//데이터베이스 파일의 경우, 메모리 내 데이터베이스의 경우 null -> 데이터베이스 이름
    factory: SQLiteDatabase.CursorFactory?,//커서 객체를 생성하는 데 사용하거나 기본값으로 null -> 데이터베이스 객체 사용
    version: Int//데이터베이스를 업그레이드하는 데 사용 -> 데이터베이스 버전관리
) : SQLiteOpenHelper(context, name, factory, version) {


    override fun onCreate(db: SQLiteDatabase?) {
        val sql: String = " CREATE TABLE IF NOT EXISTS first_plant( " +
                "    idx INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "    image TEXT,name TEXT,content TEXT)  "
        db?.execSQL(sql) //데이터를 반환하지 않는 단일 SQL 문을 만들어 줍니다

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sql: String = " DROP TABLE IF EXISTS first_plant" //테이블며은 소문자
        db?.execSQL(sql)
        onCreate(db)
    }

    //insert
    fun insert(db: SQLiteDatabase, name: String, content: String, image: String) {
        val sql =
            " INSERT INTO first_plant(image,name,content) VALUES('${image}','${name}','${content}')"
        db.execSQL(sql)
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

    fun delete(db: SQLiteDatabase, fruit_name: String) {
        val sql = " DELETE FROM first_plant WHERE name='${fruit_name}'"
        db.execSQL(sql)
    }
}

