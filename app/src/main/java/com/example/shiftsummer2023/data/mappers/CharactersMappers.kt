package com.example.shiftsummer2023.data.mappers

import com.example.shiftsummer2023.data.local.entity.CharactersEntity
import com.example.shiftsummer2023.data.remote.dto.CharactersDto
import com.example.shiftsummer2023.domain.model.Characters

fun CharactersDto.toCharactersEntity(): CharactersEntity {
    return CharactersEntity(
        info = info.toInfoEntity(),
        results = results.map { it.toCharacterEntity() }
    )
}

fun CharactersDto.toCharacters(): Characters {
    return Characters(
        info = info.toInfo(),
        results = results.map { it.toCharacter() }
    )
}

fun CharactersEntity.toCharacters(): Characters {
    return Characters(
        info = info.toInfo(),
        results = results.map { it.toCharacter() }
    )
}