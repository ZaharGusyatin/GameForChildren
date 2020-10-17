package com.example.gameforchildren.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gameforchildren.R
import com.example.gameforchildren.model.MainItemModel
import kotlinx.android.synthetic.main.main_item.view.*

class MainAdapter(var items: List<MainItemModel>,val function:(pos:Int)-> Unit) : RecyclerView.Adapter<MainAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val phone = items[position]
        holder.imageView.setImageResource(phone.imageLevel)
        holder.nameView.text = phone.name
        holder.imageView.setOnClickListener {function(position)}
    }

    inner class MainHolder internal constructor(view: View) :
        RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.pictureLevel
        val nameView: TextView = view.nameOfLevel


    }

     /*   fun bind(item: MainItemModel) {
          firstName.setImageResource()
            lastName.text = item.lastName
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) callback.onItemClicked(items[adapterPosition])
            }
        }*/


    interface Callback {
        fun onItemClicked(item: MainItemModel)
    }

}