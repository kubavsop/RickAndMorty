package com.example.shiftsummer2023.data

import retrofit2.http.GET
import retrofit2.http.Url

interface RickAndMortyApi {

    @GET("character")
    suspend fun getFirstPage(): Characters

    @GET
    suspend fun getPage(@Url url: String): Characters
}