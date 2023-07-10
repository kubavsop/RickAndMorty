package com.example.shiftsummer2023.data.models

data class CharacterModel(
    val id: Int,
    val name: String,
    val status: CharacterStatusModel,
    val species: String,
    val type: String,
    val gender: CharacterGenderModel,
    val origin: CharacterLocationModel,
    val location: CharacterLocationModel,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)
