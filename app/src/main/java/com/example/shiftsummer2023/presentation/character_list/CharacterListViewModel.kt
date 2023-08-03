package com.example.shiftsummer2023.presentation.character_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.shiftsummer2023.data.local.entity.CharacterEntity
import com.example.shiftsummer2023.data.mappers.toCharacter
import com.example.shiftsummer2023.domain.usecase.GetCharacterByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase,
    pager: Pager<Int, CharacterEntity>
) : ViewModel() {

    val characterPagingFlow = pager
        .flow
        .map { value: PagingData<CharacterEntity> -> value.map { it.toCharacter() } }
        .cachedIn(viewModelScope)
}