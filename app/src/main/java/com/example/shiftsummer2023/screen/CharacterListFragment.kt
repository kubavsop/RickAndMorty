package com.example.shiftsummer2023.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.shiftsummer2023.data.models.CharactersConverter
import com.example.shiftsummer2023.data.repository.CharacterRepositoryImpl
import com.example.shiftsummer2023.databinding.FragmentCharacterListBinding
import com.example.shiftsummer2023.domain.models.Character
import com.example.shiftsummer2023.domain.repository.CharacterRepository
import com.example.shiftsummer2023.domain.usecase.GetFirstPageUseCase
import com.example.shiftsummer2023.domain.usecase.GetPageByUrlUseCase
import com.example.shiftsummer2023.presentation.CharacterListState
import com.example.shiftsummer2023.presentation.CharacterListViewModel


class CharacterListFragment : Fragment() {

    private var _binding: FragmentCharacterListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CharacterListViewModel by viewModels {
        viewModelFactory {
            initializer {
                val repository: CharacterRepository =
                    CharacterRepositoryImpl(charactersConverter = CharactersConverter())
                CharacterListViewModel(
                    getFirstPageUseCase = GetFirstPageUseCase(repository = repository),
                    getPageByUrlUseCase = GetPageByUrlUseCase(repository = repository)
                )
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.characterList.adapter = CharacterAdapter()
        viewModel.state.observe(viewLifecycleOwner, ::handleState)
        viewModel.loadData()
    }

    private fun handleState(state: CharacterListState) {
        when (state) {
            CharacterListState.Initial -> Unit
            is CharacterListState.Content -> showContent(state.items)
        }
    }


    private fun showContent(characters: List<Character>) {
        with(binding) {
            (characterList.adapter as? CharacterAdapter)?.characterList = characters
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}