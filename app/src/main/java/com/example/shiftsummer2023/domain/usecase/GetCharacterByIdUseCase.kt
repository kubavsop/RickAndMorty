package com.example.shiftsummer2023.domain.usecase

import com.example.shiftsummer2023.domain.models.Character
import com.example.shiftsummer2023.domain.repository.CharacterRepository

class GetCharacterByIdUseCase(private val repository: CharacterRepository) {
    suspend fun execute(id: Int): Character {
        return repository.getCharacterById(id = id)
    }
}