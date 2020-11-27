package com.example.pokeapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokeapp.ui.Regiones
import com.example.pokeapp.ui.service
import kotlinx.coroutines.*

class HomeViewModel : ViewModel(){

    private var _rList = MutableLiveData<MutableList<Regiones>>()
    val rlist: LiveData<MutableList<Regiones>>
    get() = _rList

    init {
        viewModelScope.launch {

            _rList.value = fetchRegiones()
        }
    }

    private suspend fun fetchRegiones() : MutableList<Regiones> {
        return withContext(Dispatchers.IO){
            val rgListString = service.getRegiones()

            Log.d("REGIONES", rgListString)
            mutableListOf<Regiones>()
        }
    }
}