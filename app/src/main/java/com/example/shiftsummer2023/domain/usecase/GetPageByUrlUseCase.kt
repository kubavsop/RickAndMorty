package com.example.shiftsummer2023.domain.usecase

import com.example.shiftsummer2023.domain.models.Characters
import com.example.shiftsummer2023.domain.repository.CharacterRepository

class GetPageByUrlUseCase(private val repository: CharacterRepository) {
    suspend fun execute(url: String): Characters {
        return repository.getPageByUrl(url = url)
    }
}