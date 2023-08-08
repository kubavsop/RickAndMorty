package com.example.shiftsummer2023.presentation.character_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shiftsummer2023.common.mainActivity
import com.example.shiftsummer2023.databinding.FragmentCharacterListBinding
import com.example.shiftsummer2023.domain.model.Character
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CharacterListFragment : Fragment() {

    private var _binding: FragmentCharacterListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CharacterListViewModel by activityViewModels()

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
        binding.characterList.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.characterList.adapter = CharacterAdapter(::handleCharacterClick)
        lifecycleScope.launch {
            with(binding) {
                viewModel.characterPagingFlow.collectLatest { pagingData ->
                    (characterList.adapter as? CharacterAdapter)?.submitData(pagingData)
                }
            }
        }
    }

    private fun handleCharacterClick(characterId: Int) {
        mainActivity.openInformation(characterId = characterId)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding.characterList.adapter = null
        _binding = null
    }
}