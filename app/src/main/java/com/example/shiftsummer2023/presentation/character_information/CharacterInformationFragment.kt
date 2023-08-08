package com.example.shiftsummer2023.presentation.character_information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.shiftsummer2023.common.formatCharacterGender
import com.example.shiftsummer2023.common.formatCharacterStatus
import com.example.shiftsummer2023.databinding.FragmentCharacterInformationBinding
import com.example.shiftsummer2023.domain.model.Character

class CharacterInformationFragment : Fragment() {

    private var _binding: FragmentCharacterInformationBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CharacterInformationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val args: CharacterInformationFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner, ::handleState)

        characterData()
    }

    private fun characterData() {
        viewModel.loanData(args.characterId)
    }

    private fun handleState(state: CharacterInformationState) {
        when (state) {
            CharacterInformationState.Initial -> Unit
            CharacterInformationState.Loading -> showProgress()
            is CharacterInformationState.Content -> showContent(state.character)
            is CharacterInformationState.Error -> showError(state.msg)
        }
    }

    private fun showError(message: String) {
        with(binding) {
            informationContent.isVisible = false
            progressBar.isVisible = false
            errorContent.isVisible = true

            errorText.text = message
            errorButton.setOnClickListener { characterData() }
        }
    }

    private fun showProgress() {
        with(binding) {
            errorContent.isVisible = false
            informationContent.isVisible = false
            progressBar.isVisible = true
        }
    }

    private fun showContent(character: Character) {
        with(binding) {
            progressBar.isVisible = false
            errorContent.isVisible = false
            informationContent.isVisible = true

            name.text = character.name
            status.text =
                formatCharacterStatus(context = requireContext(), status = character.status)
            species.text = character.species
            gender.text =
                formatCharacterGender(context = requireContext(), gender = character.gender)
            location.text = character.location.name
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}