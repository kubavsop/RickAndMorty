package com.example.shiftsummer2023.data.models

import com.example.shiftsummer2023.domain.models.Character
import com.example.shiftsummer2023.domain.models.CharacterGender
import com.example.shiftsummer2023.domain.models.CharacterLocation
import com.example.shiftsummer2023.domain.models.CharacterStatus
import com.example.shiftsummer2023.domain.models.Characters
import com.example.shiftsummer2023.domain.models.Info

class CharactersConverter {
    fun convert(from: CharactersModel): Characters =
        with(from) {
            Characters(
                info = convertInfo(info),
                results = results.map { convertCharacter(it) }
            )
        }

    private fun convertInfo(from: InfoModel): Info =
        with(from) {
            Info(
                count = count,
                pages = pages,
                next = next,
                prev = prev
            )
        }

    private fun convertCharacter(from: CharacterModel): Character =
        with(from) {
            Character(
                id = id,
                name = name,
                status = CharacterStatus.valueOf(status.name),
                species = species,
                type = type,
                gender = CharacterGender.valueOf(gender.name),
                origin = convertLocation(origin),
                location = convertLocation(location),
                image = image,
                episode = episode,
                url = url,
                created = created
            )
        }

    private fun convertLocation(from: CharacterLocationModel): CharacterLocation =
        with(from) {
            CharacterLocation(
                name = name,
                url = url
            )
        }
}