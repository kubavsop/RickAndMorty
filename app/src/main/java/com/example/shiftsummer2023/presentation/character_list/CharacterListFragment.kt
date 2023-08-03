package com.example.shiftsummer2023.presentation.character_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shiftsummer2023.databinding.FragmentCharacterListBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CharacterListFragment : Fragment() {

    private companion object {
        const val NUMBER_PER_ROW = 3
    }

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
        binding.characterList.adapter = CharacterAdapter()
        binding.characterList.layoutManager = GridLayoutManager(requireContext(), NUMBER_PER_ROW)
        lifecycleScope.launch {
            with(binding) {
                viewModel.characterPagingFlow.collectLatest { pagingData ->
                    (characterList.adapter as? CharacterAdapter)?.submitData(pagingData)
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding.characterList.adapter = null
        _binding = null
    }
}