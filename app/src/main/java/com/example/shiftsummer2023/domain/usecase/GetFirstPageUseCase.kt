package com.example.shiftsummer2023.domain.usecase

import com.example.shiftsummer2023.domain.models.Characters
import com.example.shiftsummer2023.domain.repository.CharacterRepository

class GetFirstPageUseCase(private val repository: CharacterRepository) {
    suspend fun execute(): Characters {
        return repository.getFirstPage()
    }
}