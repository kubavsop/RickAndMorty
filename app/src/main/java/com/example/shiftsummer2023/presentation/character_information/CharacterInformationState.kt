package com.example.shiftsummer2023.presentation.character_information

import com.example.shiftsummer2023.domain.model.Character

sealed interface CharacterInformationState {
    object Initial : CharacterInformationState

    object Loading : CharacterInformationState
    data class Content(val character: Character) : CharacterInformationState
    data class Error(val msg: String) : CharacterInformationState
}
