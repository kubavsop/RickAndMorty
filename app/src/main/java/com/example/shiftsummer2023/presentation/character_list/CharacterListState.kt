package com.example.shiftsummer2023.presentation.character_list

import com.example.shiftsummer2023.domain.model.Character

sealed interface CharacterListState {
    object Initial : CharacterListState
    data class Content(val items: List<Character>) : CharacterListState
}