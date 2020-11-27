package com.example.pokeapp.ui

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

interface RegionApiService {
    @GET("region")
    suspend fun getRegiones(): String
}

private var retrofit = Retrofit.Builder()
    .baseUrl("https://pokeapi.co/api/v2/")
    .addConverterFactory(ScalarsConverterFactory.create())
    .build()

var service: RegionApiService = retrofit.create<RegionApiService>(RegionApiService::class.java)
