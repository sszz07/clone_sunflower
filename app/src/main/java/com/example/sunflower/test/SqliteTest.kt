package com.example.sunflower.test

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.sunflower.DBHelper
import com.example.sunflower.R


class SqliteTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite_test)


        var dbHelper = DBHelper(this, "MyGarden.db", null, 1)

        Log.e("데이터 베이스 생성 확인", dbHelper.toString())

        val insertBtn = findViewById<Button>(R.id.insertBtn) //자료 입력
        val editInsert = findViewById<EditText>(R.id.editInsert) //입력 혹은 검색
        val selectBtn = findViewById<Button>(R.id.selectBtn) // 자료 조회
        val deleteBtn = findViewById<Button>(R.id.deleteBtn) // 자료 삭제
        val textView = findViewById<TextView>(R.id.textView) //검색자료 표시

        val database = dbHelper.writableDatabase

//        insertBtn.setOnClickListener {
//            //입력받은 내용 불러오기
//            val fruitName = editInsert.text
//
//            //insert함수 호출
//            val result = dbHelper.insert(database, fruitName.toString())
//
//            if (result != null) {
//                textView.text = "입력한 데이터 ${fruitName}가 저장되었습니다."
//            } else {
//                textView.text = "데이터가 입력되지 않았습니다."
//            }
//        }

//        selectBtn.setOnClickListener {
//            val fruitName = editInsert.text
//            textView.text = dbHelper.select(database, fruitName.toString())
//        }

        deleteBtn.setOnClickListener {

            val fruitName = editInsert.text

            //delete 함수 호출
            val result = dbHelper.delete(database, fruitName.toString())

            if (result != null) {
                textView.text = "데이터값 ${fruitName}가 삭제 됐습니다."
            } else {
                textView.text = "데이터가 입력되지 않았습니다."
            }
        }
    }
}