package com.example.shiftsummer2023.data.remote

import com.example.shiftsummer2023.data.remote.dto.CharacterDto
import com.example.shiftsummer2023.data.remote.dto.CharactersDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("character")
    suspend fun getCharacterList(@Query("page") page: Int): CharactersDto

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): CharacterDto
}