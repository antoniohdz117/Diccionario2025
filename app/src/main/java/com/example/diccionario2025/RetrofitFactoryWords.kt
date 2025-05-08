package com.example.diccionario2025

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
object RetrofitFactoryWords {

    private const val BASE_URL = "https://demapi.colmex.mx"

    fun makeRetrofitService(): RetrofitServiceWords {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create().asLenient())
            .build()
            .create(RetrofitServiceWords::class.java)


    }


}