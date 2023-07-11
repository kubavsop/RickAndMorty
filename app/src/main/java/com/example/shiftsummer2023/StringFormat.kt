package com.example.shiftsummer2023

import android.content.Context
import com.example.shiftsummer2023.domain.models.CharacterGender
import com.example.shiftsummer2023.domain.models.CharacterStatus

fun formatCharacterStatus(context: Context, status: CharacterStatus): String =
    when (status) {
        CharacterStatus.ALIVE -> context.getString(R.string.alive)
        CharacterStatus.DEAD -> context.getString(R.string.dead)
        CharacterStatus.UNKNOWN -> context.getString(R.string.unknown)
    }

fun formatCharacterGender(context: Context, gender: CharacterGender): String =
    when (gender) {
        CharacterGender.FEMALE -> context.getString(R.string.female)
        CharacterGender.UNKNOWN -> context.getString(R.string.unknown)
        CharacterGender.GENDERLESS -> context.getString(R.string.genderless)
        CharacterGender.MALE -> context.getString(R.string.male)
    }