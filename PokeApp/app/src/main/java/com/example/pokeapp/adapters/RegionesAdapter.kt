package com.example.pokeapp.homeRepository

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.databinding.RegionListItemBinding
import com.example.pokeapp.ui.PokemonActivity

private val TAG = RegionesAdapter::class.java.simpleName

class RegionesAdapter(val context: Context) : ListAdapter<Regiones, RegionesAdapter.RgViewHolder>(DiffCallback){
    
    companion object DiffCallback : DiffUtil.ItemCallback<Regiones>() {
         override fun areItemsTheSame(oldItem: Regiones, newItem: Regiones): Boolean {
             return oldItem.regionname == newItem.regionname
         }

         override fun areContentsTheSame(oldItem: Regiones, newItem: Regiones): Boolean {
             return  oldItem == newItem
         }

     }

    lateinit var onItemClickListener: (Regiones) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RgViewHolder {
        val binding = RegionListItemBinding.inflate(LayoutInflater.from(parent.context))
        return RgViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RgViewHolder, position: Int) {
        val region = getItem(position)
        holder.bind(region)
    }

    inner class RgViewHolder(private val binding: RegionListItemBinding) :
            RecyclerView.ViewHolder(binding.root){

        fun bind(region: Regiones) {
            binding.txtTitle.text = region.regionname
            binding.root.setOnClickListener {
                context.startActivity(Intent(context, PokemonActivity::class.java))
//                if (::onItemClickListener.isInitialized) {
//                    onItemClickListener(region)
//                } else {
//
//                }
            }
        }
    }
}