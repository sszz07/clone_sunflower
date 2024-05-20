package com.example.sunflower

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class SelectFruit : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_select_fruit)

        var imv_fruit_image = findViewById<ImageView>(R.id.imv_fruit_image)
        var tv_select_fruit_name = findViewById<TextView>(R.id.tv_select_fruit_name)
        var tv_select_fruit_content = findViewById<TextView>(R.id.tv_select_fruit_content)
        var tv_wiki = findViewById<TextView>(R.id.tv_wiki)
        var imb_back = findViewById<ImageButton>(R.id.imb_back)


        val name = intent.getStringExtra("name")
        val content = intent.getStringExtra("content")
        val image = intent.getIntExtra("image", 0)

        tv_select_fruit_name.text = name
        tv_select_fruit_content.text = content
        imv_fruit_image.setImageResource(image)

        tv_wiki.paintFlags = Paint.UNDERLINE_TEXT_FLAG


        imb_back.setOnClickListener{onBackPressed()}

        tv_wiki.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://ko.wikipedia.org/wiki/"+name))
            startActivity(intent)
        }
    }
}
