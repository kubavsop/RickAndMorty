package com.example.shiftsummer2023.data.remote

import com.example.shiftsummer2023.data.remote.dto.CharactersDto
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface RickAndMortyApi {


    @GET("character")
    suspend fun getCharacterList(@Query("page") page: Int): CharactersDto

    @GET("character")
    suspend fun getFirstPage(): CharactersDto

    @GET
    suspend fun getPageByUrl(@Url url: String): CharactersDto
}