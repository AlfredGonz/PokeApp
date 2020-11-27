package com.example.pokeapp.homeRepository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

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