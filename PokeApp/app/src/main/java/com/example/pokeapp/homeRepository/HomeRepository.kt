package com.example.pokeapp.homeRepository

import com.example.pokeapp.models.Regiones
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeRepository {

     suspend fun fetchRegiones() : MutableList<Regiones> {
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