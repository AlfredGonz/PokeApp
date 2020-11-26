package com.example.pokeapp.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.databinding.RegionListItemBinding

private val TAG = RegionesAdapter::class.java.simpleName

class RegionesAdapter : ListAdapter<Regiones, RegionesAdapter.RgViewHolder>(DiffCallback){

     companion object DiffCallback : DiffUtil.ItemCallback<Regiones>() {
         override fun areItemsTheSame(oldItem: Regiones, newItem: Regiones): Boolean {
             return oldItem.regionname == newItem.regionname
         }

         override fun areContentsTheSame(oldItem: Regiones, newItem: Regiones): Boolean {
             return  oldItem == newItem
         }

     }

    lateinit var onItemClickListener: (Regiones) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegionesAdapter.RgViewHolder {
        val binding = RegionListItemBinding.inflate(LayoutInflater.from(parent.context))
        return RgViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RegionesAdapter.RgViewHolder, position: Int) {
        val region = getItem(position)
        holder.bind(region)
    }

    inner class RgViewHolder(private val binding: RegionListItemBinding) :
            RecyclerView.ViewHolder(binding.root){
        fun bind(region: Regiones) {
            binding.txtTitle.text = region.regionname
            binding.root.setOnClickListener {
                if (::onItemClickListener.isInitialized) {
                    onItemClickListener(region)
                } else {
                    Log.e(TAG, "onItemClickListener no inicializado")
                }
            }
        }
    }
}