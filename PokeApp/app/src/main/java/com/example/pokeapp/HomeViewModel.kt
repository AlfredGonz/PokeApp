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
            val rgListString = service.getRegiones()
            val regionesList = parseRegionesResult(rgListString)
            
            regionesList
        }
    }

    private fun parseRegionesResult(rgListString: String): MutableList<Regiones> {
        val rgJsonObject = JSONObject(rgListString)
        val resultJsonArray = rgJsonObject.getJSONArray("results")

        val regionesList = mutableListOf<Regiones>()

        for (i in 0 until resultJsonArray.length()) {
            val resultJsonObject = resultJsonArray[i] as JSONObject
            val nombre = resultJsonObject.getString("name")

            val region = Regiones(nombre)
            regionesList.add(region)
        }

        return regionesList
    }
}