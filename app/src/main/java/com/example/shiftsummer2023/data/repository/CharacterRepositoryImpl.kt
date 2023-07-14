package com.example.shiftsummer2023.data.repository

import com.example.shiftsummer2023.data.mappers.toCharacter
import com.example.shiftsummer2023.data.mappers.toCharacters
import com.example.shiftsummer2023.data.remote.RickAndMortyApi
import com.example.shiftsummer2023.domain.models.Character
import com.example.shiftsummer2023.domain.models.Characters
import com.example.shiftsummer2023.domain.repository.CharacterRepository

class CharacterRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi
) : CharacterRepository {
    override suspend fun getCharacterById(id: Int): Character {
        return rickAndMortyApi.getCharacterById(id = id).toCharacter()
    }
}