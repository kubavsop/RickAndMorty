package com.example.shiftsummer2023.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class CharacterEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val status: CharacterStatusEntity,
    val species: String,
    val type: String,
    val gender: CharacterGenderEntity,
    val origin: CharacterLocationEntity,
    val location: CharacterLocationEntity,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)
