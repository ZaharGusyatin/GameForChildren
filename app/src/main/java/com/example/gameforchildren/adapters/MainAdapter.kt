package com.example.gameforchildren.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gameforchildren.R
import com.example.gameforchildren.model.MainItemModel

class MainAdapter(var items: List<MainItemModel>, val callback: Callback) : RecyclerView.Adapter<MainAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_item, parent, false))

    override fun getItemCount() = items.size




    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(items[position])

    }

    inner class MainHolder internal constructor(view: View) :
        RecyclerView.ViewHolder(view) {
        private val firstName = itemView.findViewById<ImageView>(R.id.pictureLevel)
        private val lastName = itemView.findViewById<TextView>(R.id.nameOfLevel)





        fun bind(item: MainItemModel) {
            firstName.setImageResource(item.firstName)
            lastName.text = item.lastName
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) callback.onItemClicked(items[adapterPosition])
            }
        }
        }


    interface Callback {
        fun onItemClicked(item: MainItemModel)
    }

}
