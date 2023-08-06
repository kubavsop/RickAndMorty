package com.example.shiftsummer2023.presentation.character_information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.shiftsummer2023.databinding.FragmentCharacterInformationBinding

class CharacterInformationFragment : Fragment() {

    private var _binding: FragmentCharacterInformationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCharacterInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val args: CharacterInformationFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}