package com.example.shiftsummer2023.domain.model


data class Character(
    val id: Int,
    val name: String,
    val status: CharacterStatus,
    val species: String,
    val gender: CharacterGender,
    val location: CharacterLocation,
    val image: String,
)