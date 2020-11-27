package com.example.pokeapp.homeRepository

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface RegionApiService {
    @GET("region")
    suspend fun getRegiones(): RegionesJsonResponse
}

private var retrofit = Retrofit.Builder()
    .baseUrl("https://pokeapi.co/api/v2/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

var service: RegionApiService = retrofit.create<RegionApiService>(RegionApiService::class.java)
