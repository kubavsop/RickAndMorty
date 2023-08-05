package com.example.shiftsummer2023.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.shiftsummer2023.R
import com.example.shiftsummer2023.databinding.ActivityMainBinding
import com.example.shiftsummer2023.presentation.character_list.CharacterListFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val navController: NavController get() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        return navHostFragment.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun openInformation() {
        val action = CharacterListFragmentDirections.actionCharacterListFragmentToCharacterInformationFragment()
        navController.navigate(action)
    }
}