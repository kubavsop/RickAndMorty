package com.example.shiftsummer2023.data.mappers

import com.example.shiftsummer2023.data.local.entity.InfoEntity
import com.example.shiftsummer2023.data.remote.dto.InfoDto
import com.example.shiftsummer2023.domain.model.Info

fun InfoDto.toInfoEntity(): InfoEntity {
    return InfoEntity(
        count = count,
        pages = pages,
        next = next,
        prev = prev
    )
}

fun InfoDto.toInfo(): Info {
    return Info(
        count = count,
        pages = pages,
        next = next,
        prev = prev
    )
}


fun InfoEntity.toInfo(): Info {
    return Info(
        count = count,
        pages = pages,
        next = next,
        prev = prev
    )
}