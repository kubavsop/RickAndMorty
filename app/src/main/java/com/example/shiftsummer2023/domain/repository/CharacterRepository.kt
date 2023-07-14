package com.example.shiftsummer2023.domain.repository

import com.example.shiftsummer2023.domain.models.Character

interface CharacterRepository {
    suspend fun getCharacterById(id: Int): Character
}