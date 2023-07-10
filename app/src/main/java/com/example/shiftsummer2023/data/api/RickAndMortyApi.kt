package com.example.shiftsummer2023.data.api

import com.example.shiftsummer2023.data.models.CharactersModel
import retrofit2.http.GET
import retrofit2.http.Url

interface RickAndMortyApi {

    @GET("character")
    suspend fun getFirstPage(): CharactersModel

    @GET
    suspend fun getPageByUrl(@Url url: String): CharactersModel
}