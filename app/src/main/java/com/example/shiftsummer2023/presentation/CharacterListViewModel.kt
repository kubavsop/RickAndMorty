package com.example.shiftsummer2023.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.shiftsummer2023.data.local.entity.CharacterEntity
import com.example.shiftsummer2023.data.mappers.toCharacter
import com.example.shiftsummer2023.domain.usecase.GetFirstPageUseCase
import com.example.shiftsummer2023.domain.usecase.GetPageByUrlUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val getFirstPageUseCase: GetFirstPageUseCase,
    private val getPageByUrlUseCase: GetPageByUrlUseCase,
    pager: Pager<Int, CharacterEntity>
) : ViewModel() {

    val characterPagingFlow = pager
        .flow
        .map { value: PagingData<CharacterEntity> -> value.map { it.toCharacter() } }
        .cachedIn(viewModelScope)


//    private val _state = MutableLiveData<CharacterListState>(CharacterListState.Initial)
//    val state: LiveData<CharacterListState> = _state
//
//    fun loadData() {
//        viewModelScope.launch {
//            val characters = getFirstPageUseCase.execute()
//            _state.value = CharacterListState.Content(characters.results)
//        }
//    }
}