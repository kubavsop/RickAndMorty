package com.example.shiftsummer2023.domain.repository
import com.example.shiftsummer2023.domain.models.Characters

interface CharacterRepository {
    suspend fun getFirstPage(): Characters
    suspend fun getPageByUrl(url: String): Characters
}