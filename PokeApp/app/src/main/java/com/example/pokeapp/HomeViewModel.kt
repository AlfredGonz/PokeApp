package com.example.pokeapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokeapp.ui.Regiones
import com.example.pokeapp.ui.service
import kotlinx.coroutines.*
import org.json.JSONObject

class HomeViewModel : ViewModel(){

    private var _rList = MutableLiveData<MutableList<Regiones>>()
    val rlist: LiveData<MutableList<Regiones>>
    get() = _rList

    private val repository = HomeRepository()
    init {
        viewModelScope.launch {

            _rList.value = repository.fetchRegiones()
        }
    }


}