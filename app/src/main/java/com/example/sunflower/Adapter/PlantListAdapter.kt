package com.example.sunflower.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.sunflower.PlantList
import com.example.sunflower.R
import com.example.sunflower.SelectFruit



class PlantListAdapter(val PlantList: ArrayList<PlantList>) :
    RecyclerView.Adapter<PlantListAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_list_fragment_item, parent, false)
        return CustomViewHolder(view).apply {
        }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.fruitImage.setImageResource(PlantList.get(position).fruitImage)
        holder.fruitName.text = PlantList.get(position).fruitName

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,SelectFruit::class.java)
            intent.putExtra("name",PlantList.get(position).fruitName)
            intent.putExtra("content",PlantList.get(position).fruitContent)
            intent.putExtra("image",PlantList.get(position).fruitImage)
            ContextCompat.startActivity(holder.itemView.context,intent,null)
        }
    }

    override fun getItemCount(): Int {
        return PlantList.size
    }

    class CustomViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        val fruitName = itemview.findViewById<TextView>(R.id.tv_fruit_name)
        val fruitImage = itemview.findViewById<ImageView>(R.id.im_fruit_image)


    }
}