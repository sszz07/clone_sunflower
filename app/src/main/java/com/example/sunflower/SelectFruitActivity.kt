package com.example.sunflower

import android.annotation.SuppressLint
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/*
 * 1.SelectFruit -> SelectFruitActivity 어떤 클래스인지 구분하기 위해 Activity 넣기
 * 2.클래스와 변수명 헷갈리지 않게 변수명은 소문자로 시작 / 클래스는 대문자로 시작
 * 3.코드 종료시 코들 정렬 하기
 * */

class SelectFruitActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_fruit)

        val dbHelper = DBHelper(this, "MyGarden.db", null, 1)
        val database = dbHelper.writableDatabase

        val imv_fruit_image = findViewById<ImageView>(R.id.imv_fruit_image)
        val tv_select_fruit_name = findViewById<TextView>(R.id.tv_select_fruit_name)
        val tv_select_fruit_content = findViewById<TextView>(R.id.tv_select_fruit_content)
        val tv_wiki = findViewById<TextView>(R.id.tv_wiki)
        val imb_back = findViewById<ImageButton>(R.id.imb_back)
        val imgbtn_my_garden = findViewById<ImageButton>(R.id.imgbtn_my_garden)
        val imgbtn_my_garden_delete = findViewById<ImageButton>(R.id.imgbtn_my_garden_delete)


        val name = intent.getStringExtra("name")
        val content = intent.getStringExtra("content")
        val image = intent.getIntExtra("image", 0)
        val fragment = intent.getStringExtra("fragment")


        tv_select_fruit_name.text = name
        tv_select_fruit_content.text = content
        imv_fruit_image.setImageResource(image)

        tv_wiki.paintFlags = Paint.UNDERLINE_TEXT_FLAG


        imb_back.setOnClickListener { onBackPressed() }


        val result = dbHelper.select(database, name.toString())
        Log.e("result", result.toString() + "값 확인")


        //db에 값이 존재했을때 그리고 PlantListFragment에서 선택했을때
        if (result != null && fragment == "PlantListFragment") {
            imgbtn_my_garden.visibility = View.INVISIBLE
            imgbtn_my_garden_delete.visibility = View.INVISIBLE
        }

        //db에 값이 존재했을때 그리고 MyGardenFragment에서 선택했을때
        else if (result != null && fragment == " MyGardenFragment") {
            imgbtn_my_garden_delete.visibility = View.VISIBLE
            imgbtn_my_garden.visibility = View.INVISIBLE
        } else if (fragment == "PlantListFragment") {
            imgbtn_my_garden.visibility = View.VISIBLE
            imgbtn_my_garden_delete.visibility = View.INVISIBLE
        }


        tv_wiki.setOnClickListener {
            val intent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://ko.wikipedia.org/wiki/" + name))
            startActivity(intent)
        }


        imgbtn_my_garden.setOnClickListener {
            //insert함수 호출
            dbHelper.insert(database, name.toString(), content.toString(), image)
            Toast.makeText(this, "추가 되었습니다", Toast.LENGTH_SHORT).show()
            imgbtn_my_garden.visibility = View.INVISIBLE
        }

        imgbtn_my_garden_delete.setOnClickListener {
            showDialog(name!!, dbHelper, database)
        }
    }


    fun showDialog(fruit_name: String, dbHelper: DBHelper, database: SQLiteDatabase) {
        val dialog = android.app.Dialog(this)
        dialog.setContentView(R.layout.dialog_confirm)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        //다이얼로그 취소하기
        val bt_dialog_no = dialog.findViewById<Button>(R.id.bt_dialog_no)
        bt_dialog_no.setOnClickListener() {
            dialog.dismiss()
        }

        val bt_dialog_yes = dialog.findViewById<Button>(R.id.bt_dialog_yes)
        bt_dialog_yes.setOnClickListener() {
            Delte(fruit_name, dbHelper, database)
            dialog.dismiss()
        }


    }

    fun Delte(fruit_name: String, dbHelper: DBHelper, database: SQLiteDatabase) {
        dbHelper.delete(database, fruit_name)
        Toast.makeText(this, "삭제 되었습니다", Toast.LENGTH_SHORT).show()
        onBackPressed()
    }
}
