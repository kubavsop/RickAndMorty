package com.example.shiftsummer2023.data.api

import com.example.shiftsummer2023.data.dto.CharactersDto
import retrofit2.http.GET
import retrofit2.http.Url

interface RickAndMortyApi {

    @GET("character")
    suspend fun getFirstPage(): CharactersDto

    @GET
    suspend fun getPageByUrl(@Url url: String): CharactersDto
}