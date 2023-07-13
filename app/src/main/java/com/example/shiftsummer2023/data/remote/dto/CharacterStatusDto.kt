package com.example.shiftsummer2023.data.remote.dto

import com.google.gson.annotations.SerializedName

enum class CharacterStatusDto {
    @SerializedName("Alive")
    ALIVE,

    @SerializedName("Dead")
    DEAD,

    @SerializedName("unknown")
    UNKNOWN
}