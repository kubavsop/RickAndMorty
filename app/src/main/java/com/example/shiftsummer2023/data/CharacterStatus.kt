package com.example.shiftsummer2023.data

import com.google.gson.annotations.SerializedName

enum class CharacterStatus {
    @SerializedName("Alive")
    ALIVE,
    @SerializedName("Dead")
    DEAD,
    @SerializedName("unknown")
    UNKNOWN
}