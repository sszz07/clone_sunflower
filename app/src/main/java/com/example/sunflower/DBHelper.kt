package com.example.sunflower

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log


class DBHelper(
    context: Context?, //데이터베이스에 대한 경로를 찾는 데 사용합니다. 이 값은 null -> 해석 안드로이드에서 제공하는 api에 접근하기 위해 사용
    name: String?,//데이터베이스 파일의 경우, 메모리 내 데이터베이스의 경우 null -> 데이터베이스 이름
    factory: SQLiteDatabase.CursorFactory?,//커서 객체를 생성하는 데 사용하거나 기본값으로 null -> 데이터베이스 객체 사용
    version: Int//데이터베이스를 업그레이드하는 데 사용 -> 데이터베이스 버전관리
) : SQLiteOpenHelper(context, name, factory, version) {


    override fun onCreate(db: SQLiteDatabase?) {
        //쿼리문. 존재하지 않는다면 테이블을 생성하라는 말
        //DB 코딩컨벤션 - 안드로이드 공식문서에서 두개의 단어일때 앞글자를 대문자를 사용함
        // 쿼리문 해석
        // CREATE TABLE IF NOT EXISTS MYGARDEN    MYGARDEN이 존재하지 않는다면
        // idx INTEGER PRIMARY KEY AUTOINCREMENT 정수형 타입,기준키,자동 상승으로 해서 idx 컬럼명으로 함
        // fruit_image컬럼은 정수형 , fruit_name은 text ,content는 text

        //CREATE TABLE IF NOT EXISTS 테이블이 존재하지 않는다면
        val sql: String = " CREATE TABLE IF NOT EXISTS my_garden( " +
                "    idx INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "    fruit_image INTEGER,fruit_name TEXT,fruit_content TEXT)  "
        db?.execSQL(sql) //데이터를 반환하지 않는 단일 SQL 문을 만들어 줍니다
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sql: String = " DROP TABLE IF EXISTS my_garden" //테이블며은 소문자
        db?.execSQL(sql)
        onCreate(db)
    }

    //insert
    fun insert(db: SQLiteDatabase, fruitName: String, fruitContent: String, fruitImage: Int) {
        val sql =
            " INSERT INTO my_garden(fruit_name,fruit_content,fruit_image) VALUES('${fruitName}','${fruitContent}','${fruitImage}')"
        db.execSQL(sql)
    }

    //select문
    @SuppressLint("Range", "Recycle")
    fun select(db: SQLiteDatabase, fruit_name: String): String? {
        val sql = " SELECT * FROM my_garden  WHERE fruit_name='${fruit_name}'"
        val result = db.rawQuery(sql, null)
        var str: String? = null
        while (result.moveToNext()) {
            str += "번호 :" + result.getString(result.getColumnIndex("idx")) + "\n" +
                    "데이터 :" + result.getString(result.getColumnIndex("fruit_name"))
        }
        return str
    }


    //삭제코드
    fun delete(db: SQLiteDatabase, fruit_name: String) {
        val sql = " DELETE FROM my_garden WHERE fruit_name='${fruit_name}'"
        db.execSQL(sql)
    }
}

