package com.example.shiftsummer2023.data.repository

import com.example.shiftsummer2023.data.api.RickAndMortyApi
import com.example.shiftsummer2023.data.models.CharactersConverter
import com.example.shiftsummer2023.domain.models.Characters
import com.example.shiftsummer2023.domain.repository.CharacterRepository
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class CharacterRepositoryImpl (private val charactersConverter: CharactersConverter): CharacterRepository {

    private companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
        const val CONNECT_TIMEOUT = 10L
        const val WRITE_TIMEOUT = 10L
        const val READ_TIMEOUT = 10L
    }

    private val gson = GsonBuilder()
        .create()

    private val retrofit = Retrofit.Builder()
        .client(provideOkHttpClientWithProgress())
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    private val rickAndMortyApi by lazy {
        retrofit.create(RickAndMortyApi::class.java)
    }

    override suspend fun getFirstPage(): Characters {
        return charactersConverter.convert(rickAndMortyApi.getFirstPage())
    }

    override suspend fun getPageByUrl(url: String): Characters {
        return charactersConverter.convert(rickAndMortyApi.getPageByUrl(url))
    }

    private fun provideOkHttpClientWithProgress(): OkHttpClient =
        OkHttpClient().newBuilder()
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .build()
}