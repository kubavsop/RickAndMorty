package com.example.shiftsummer2023.data.mappers

import com.example.shiftsummer2023.data.local.entity.CharacterLocationEntity
import com.example.shiftsummer2023.data.remote.dto.CharacterLocationDto
import com.example.shiftsummer2023.domain.models.CharacterLocation

fun CharacterLocationDto.toCharacterLocationEntity(): CharacterLocationEntity {
    return CharacterLocationEntity(
        name = name, url = url
    )
}

fun CharacterLocationDto.toCharacterLocation(): CharacterLocation {
    return CharacterLocation(
        name = name, url = url
    )
}


fun CharacterLocationEntity.toCharacterLocation(): CharacterLocation {
    return CharacterLocation(
        name = name, url = url
    )
}