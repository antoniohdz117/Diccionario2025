package com.example.diccionario2025

import retrofit2.Response
import retrofit2.http.*


interface RetrofitServiceWords {

    @GET("/api/Palabras/GetPalabraFormada/{palabra}")
    suspend fun getPalabraFormada(
        @Path("palabra")palabra: String,
        @Header("token") token: String,
        @Header("cliente") cliente: String,
        ) : Response<Array<ResultadosFragment.Word>>

    @GET("/api/Palabras/GetPalabraAleatoria/{palabra}")
    suspend fun getPalabraAleatoria(
        @Path("palabra")palabra: String,
        @Header("token") token: String,
        @Header("cliente") cliente: String,
    ) : Response<Array<ResultadosFragment.Word>>

    //@POST()

    //@PUT()

    //@DELETE()


}

