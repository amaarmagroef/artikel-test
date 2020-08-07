package com.example.apaini.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apaini.R
import com.example.apaini.data.model.List
import kotlinx.android.synthetic.main.item_artikel.view.*

class AdapterArtikel() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var data = mutableListOf<List>()

    fun update(list : MutableList<List>){
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holder: RecyclerView.ViewHolder
        val view: View
        val inflater = LayoutInflater.from(parent.context)
        view = inflater.inflate(R.layout.item_artikel, parent, false)
        holder = ArtikelViewHolder(view)
        return holder
    }

    override fun getItemCount() : Int {
        return data.size
    }

    inner class ArtikelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = data[position]
        Glide.with(holder.itemView)
            .load(item.imageUrl)
            .into(holder.itemView.image)
        holder.itemView.title.text = item.title
        holder.itemView.description.text = item.description
    }

}