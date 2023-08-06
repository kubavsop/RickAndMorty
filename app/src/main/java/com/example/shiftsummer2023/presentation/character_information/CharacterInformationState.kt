package com.example.shiftsummer2023.presentation.character_information

import com.example.shiftsummer2023.domain.model.Character

sealed interface CharacterInformationState {
    object Initial : CharacterInformationState
    data class Content(val character: Character) : CharacterInformationState
}
