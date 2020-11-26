package com.example.pokeapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.R

class RegionesAdapter : ListAdapter<Regiones, RegionesAdapter.RgViewHolder>(DiffCallback){

     companion object DiffCallback : DiffUtil.ItemCallback<Regiones>() {
         override fun areItemsTheSame(oldItem: Regiones, newItem: Regiones): Boolean {
             return oldItem.regionname == newItem.regionname
         }

         override fun areContentsTheSame(oldItem: Regiones, newItem: Regiones): Boolean {
             return  oldItem == newItem
         }

     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegionesAdapter.RgViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.region_list_item, parent, false)

        return RgViewHolder(view)
    }

    override fun onBindViewHolder(holder: RegionesAdapter.RgViewHolder, position: Int) {
        val region = getItem(position)
        holder.nombreRegion.text = region.regionname
    }

    inner class RgViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val nombreRegion = view.findViewById<TextView>(R.id.txt_title)
    }
}