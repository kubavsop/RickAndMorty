package com.example.shiftsummer2023.data.remote.dto

data class CharacterDto(
    val id: Int,
    val name: String,
    val status: CharacterStatusDto,
    val species: String,
    val type: String,
    val gender: CharacterGenderDto,
    val origin: CharacterLocationDto,
    val location: CharacterLocationDto,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)
