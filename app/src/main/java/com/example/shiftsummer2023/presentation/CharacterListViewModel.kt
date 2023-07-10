package com.example.shiftsummer2023.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shiftsummer2023.domain.usecase.GetFirstPageUseCase
import com.example.shiftsummer2023.domain.usecase.GetPageByUrlUseCase
import kotlinx.coroutines.launch

class CharacterListViewModel(
    private val getFirstPageUseCase: GetFirstPageUseCase,
    private val getPageByUrlUseCase: GetPageByUrlUseCase
) : ViewModel() {
    private val _state = MutableLiveData<CharacterListState>(CharacterListState.Initial)
    val state: LiveData<CharacterListState> = _state

    fun loadData() {
        viewModelScope.launch {
            val characters = getFirstPageUseCase.execute()
            _state.value = CharacterListState.Content(characters.results)
        }
    }
}