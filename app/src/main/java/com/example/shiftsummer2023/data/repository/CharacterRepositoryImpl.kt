package com.example.shiftsummer2023.data.repository

import com.example.shiftsummer2023.data.api.RickAndMortyApi
import com.example.shiftsummer2023.data.models.CharactersConverter
import com.example.shiftsummer2023.domain.models.Characters
import com.example.shiftsummer2023.domain.repository.CharacterRepository

class CharacterRepositoryImpl(
    private val charactersConverter: CharactersConverter,
    private val rickAndMortyApi: RickAndMortyApi
) : CharacterRepository {

    override suspend fun getFirstPage(): Characters {
        return charactersConverter.convert(rickAndMortyApi.getFirstPage())
    }

    override suspend fun getPageByUrl(url: String): Characters {
        return charactersConverter.convert(rickAndMortyApi.getPageByUrl(url))
    }
}