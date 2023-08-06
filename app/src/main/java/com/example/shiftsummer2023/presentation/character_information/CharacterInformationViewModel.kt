package com.example.shiftsummer2023.presentation.character_information

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shiftsummer2023.domain.usecase.GetCharacterByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterInformationViewModel @Inject constructor(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase,
): ViewModel() {
    private val _state: MutableLiveData<CharacterInformationState> = MutableLiveData(CharacterInformationState.Initial)
    val state: LiveData<CharacterInformationState> = _state

    fun loanData(id: Int) {
        viewModelScope.launch {
            val character = getCharacterByIdUseCase.execute(id)
            _state.value = CharacterInformationState.Content(character)
        }
    }
}