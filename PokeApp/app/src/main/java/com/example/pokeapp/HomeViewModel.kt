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

    init {
        viewModelScope.launch {

            _rList.value = fetchRegiones()
        }
    }

    private suspend fun fetchRegiones() : MutableList<Regiones> {
        return withContext(Dispatchers.IO){
            val rgJsonResponse = service.getRegiones()
            val regionesList = parseRegionesResult(rgJsonResponse)

            regionesList
        }
    }

    private fun parseRegionesResult(rgJsonResponse: RegionesJsonResponse): MutableList<Regiones> {

        val regionesList = mutableListOf<Regiones>()

        val resultList = rgJsonResponse.results

        for (result in resultList) {
            val name = result.name

            regionesList.add(Regiones(name))
        }

        return regionesList
    }
}