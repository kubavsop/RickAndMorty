package com.example.shiftsummer2023.presentation.character_information

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shiftsummer2023.domain.usecase.GetCharacterByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterInformationViewModel @Inject constructor(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase,
) : ViewModel() {
    private val _state: MutableLiveData<CharacterInformationState> =
        MutableLiveData(CharacterInformationState.Initial)
    val state: LiveData<CharacterInformationState> = _state

    fun loanData(id: Int) {
        viewModelScope.launch {
            try {
                val character = getCharacterByIdUseCase.execute(id)
                _state.value = CharacterInformationState.Content(character)
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _state.value = CharacterInformationState.Error(e.message.toString())
            }
        }
    }
}