//package com.example.sunflower.adapter
//
//import android.content.Intent
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.lifecycle.LiveData
//import androidx.recyclerview.widget.RecyclerView
//import com.example.sunflower.PlantList
//import com.example.sunflower.R
//import com.example.sunflower.SelectFruitActivity
//
//
//     /*
//      * 1.불필요한 코드 없애기 .apply{}
//      * */
//class PlantListAdapter(val  plantList: ArrayList<PlantList>, val plantListFragment:String) :
//    RecyclerView.Adapter<PlantListAdapter.CustomViewHolder>() {
//
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): CustomViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.plant_list_fragment_item, parent, false)
//        return CustomViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
//        holder.fruitImage.setImageResource(plantList.value?.get(position)!!.fruitImage)
//        holder.fruitName.text = plantList.value?.get(position)!!.fruitName
//
//        holder.itemView.setOnClickListener {
//            val intent = Intent(holder.itemView.context, SelectFruitActivity::class.java)
//            intent.putExtra("name", plantList.value?.get(position)?.fruitName)
//            intent.putExtra("content", plantList.value?.get(position)?.fruitContent)
//            intent.putExtra("image", plantList.value?.get(position)?.fruitImage)
//            intent.putExtra("fragment", plantListFragment) //어떤 화면에서 왔는지 확인해주기 위한 코드
//
//            holder.itemView.context.startActivity(intent)
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return plantList.value!!.size
//    }
//
//    class CustomViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
//
//        val fruitName = itemview.findViewById<TextView>(R.id.tv_fruit_name)
//        val fruitImage = itemview.findViewById<ImageView>(R.id.im_fruit_image)
//    }
//}