package com.example.shiftsummer2023.data.models

import com.google.gson.annotations.SerializedName

enum class CharacterStatusModel {
    @SerializedName("Alive")
    ALIVE,

    @SerializedName("Dead")
    DEAD,

    @SerializedName("unknown")
    UNKNOWN
}