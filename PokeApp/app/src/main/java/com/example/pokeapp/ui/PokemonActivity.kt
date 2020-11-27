package com.example.pokeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokeapp.R
import com.example.pokeapp.databinding.ActivityHomeBinding
import com.example.pokeapp.databinding.ActivityPokemonBinding

class PokemonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}