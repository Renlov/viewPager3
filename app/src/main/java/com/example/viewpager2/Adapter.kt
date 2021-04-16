package com.example.viewpager2

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class Adapter(val arrayList: ArrayList<Item>, val context: Context) : RecyclerView.Adapter<Adapter.AdapterHolder>(){
    inner class AdapterHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var imageView : ImageView = itemView.findViewById(R.id.imageView)
        var textView : TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_blank,parent,false)
        return AdapterHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
        val currentItem : Item = arrayList[position]
        holder.textView.text = currentItem.text
        Glide.with(context).load(currentItem.image).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}
