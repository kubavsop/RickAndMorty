package com.example.shiftsummer2023

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shiftsummer2023.data.CharacterRepository

class MainActivity : AppCompatActivity() {
    val repository = CharacterRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}