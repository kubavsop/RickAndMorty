package com.example.shiftsummer2023.presentation

import com.example.shiftsummer2023.domain.models.Character

sealed interface CharacterListState {
    object Initial : CharacterListState
    data class Content(val items: List<Character>) : CharacterListState
}