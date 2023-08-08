package com.example.shiftsummer2023.data.mappers

import com.example.shiftsummer2023.data.local.entity.InfoEntity
import com.example.shiftsummer2023.data.remote.dto.InfoDto

fun InfoDto.toInfoEntity(): InfoEntity {
    return InfoEntity(
        count = count,
        pages = pages,
        next = next,
        prev = prev
    )
}
