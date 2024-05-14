package com.example.sunflower

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class PlantListAdapter(val PlantList: ArrayList<PlantList>) :
    RecyclerView.Adapter<PlantListAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlantListAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_list_fragment_item, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPos :Int = adapterPosition
                val Plant:PlantList = PlantList.get(curPos)
                Toast.makeText(parent.context,"이름: ${Plant.fruitName}}",
                    Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onBindViewHolder(holder: PlantListAdapter.CustomViewHolder, position: Int) {
        holder.fruitImage.setImageResource(PlantList.get(position).fruitImage)
        holder.fruitName.text = PlantList.get(position).fruitName
    }

    override fun getItemCount(): Int {
        return PlantList.size
    }

    class CustomViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val fruitName = itemview.findViewById<TextView>(R.id.tv_fruit_name)
        val fruitImage = itemview.findViewById<ImageView>(R.id.im_fruit_image)

    }

}