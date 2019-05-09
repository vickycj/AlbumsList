package com.vicky.apps.datapoints.ui.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vicky.apps.datapoints.R
import com.vicky.apps.datapoints.data.room.entity.Albums


class DataAdapter constructor(var albums: List<Albums>) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_child_view,parent,false)
        return DataViewHolder(v)
    }

    override fun getItemCount(): Int = albums.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.textViewTitle.text = albums[position].title

        val urlPath = "https://picsum.photos/id/${albums[position].id}/200/200"

        Picasso.get().load(urlPath).into(holder.imageView)
    }

    fun updateData(albums: List<Albums>){
        this.albums = albums
        notifyDataSetChanged()
    }
    class DataViewHolder(v:View): RecyclerView.ViewHolder(v){

        val textViewTitle = v.findViewById<TextView>(R.id.title)
        val imageView = v.findViewById<ImageView>(R.id.logo)

    }
}