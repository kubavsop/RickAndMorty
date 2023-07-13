package com.example.shiftsummer2023.data.mappers

import com.example.shiftsummer2023.data.local.entity.CharacterEntity
import com.example.shiftsummer2023.data.local.entity.CharacterGenderEntity
import com.example.shiftsummer2023.data.local.entity.CharacterStatusEntity
import com.example.shiftsummer2023.data.remote.dto.CharacterDto
import com.example.shiftsummer2023.domain.models.Character
import com.example.shiftsummer2023.domain.models.CharacterGender
import com.example.shiftsummer2023.domain.models.CharacterStatus

fun CharacterDto.toCharacterEntity(): CharacterEntity {
    return CharacterEntity(
        id = id,
        name = name,
        status = CharacterStatusEntity.valueOf(status.name),
        species = species,
        type = type,
        gender = CharacterGenderEntity.valueOf(gender.name),
        origin = origin.toCharacterLocationEntity(),
        location = location.toCharacterLocationEntity(),
        image = image,
        episode = episode,
        url = url,
        created = created
    )
}

fun CharacterDto.toCharacter(): Character {
    return Character(
        id = id,
        name = name,
        status = CharacterStatus.valueOf(status.name),
        species = species,
        type = type,
        gender = CharacterGender.valueOf(gender.name),
        origin = origin.toCharacterLocation(),
        location = location.toCharacterLocation(),
        image = image,
        episode = episode,
        url = url,
        created = created
    )
}

fun CharacterEntity.toCharacter(): Character {
    return Character(
        id = id,
        name = name,
        status = CharacterStatus.valueOf(status.name),
        species = species,
        type = type,
        gender = CharacterGender.valueOf(gender.name),
        origin = origin.toCharacterLocation(),
        location = location.toCharacterLocation(),
        image = image,
        episode = episode,
        url = url,
        created = created
    )
}