package com.dhikafruit.myrecyclerview
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import android.content.Intent

class ListFruitAdapter (private val  listFruit:ArrayList<Fruit>): RecyclerView.Adapter<ListFruitAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto : ImageView = itemView.findViewById(R.id.img_fruit_photo)
        val tvName : TextView =itemView.findViewById(R.id.fruit_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_fruit_description)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_fruit,parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listFruit.size


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listFruit[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_fruit", listFruit[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}