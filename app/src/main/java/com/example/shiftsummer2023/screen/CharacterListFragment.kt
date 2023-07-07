package com.example.shiftsummer2023.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.shiftsummer2023.data.Character
import com.example.shiftsummer2023.databinding.FragmentCharacterListBinding
import com.example.shiftsummer2023.mainActivity
import kotlinx.coroutines.launch


class CharacterListFragment : Fragment() {

    private var _binding: FragmentCharacterListBinding? = null
    private val binding get() = _binding!!

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
        launchLoadingCharacters()
    }

    private fun launchLoadingCharacters() {
        lifecycleScope.launch {
            val repository = mainActivity.repository
            val characters = repository.getFirstPage()
            showContent(characters)
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