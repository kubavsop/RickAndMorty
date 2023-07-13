package com.example.shiftsummer2023.data.dto

import com.google.gson.annotations.SerializedName

enum class CharacterGenderDto {
    @SerializedName("Female")
    FEMALE,

    @SerializedName("Male")
    MALE,

    @SerializedName("Genderless")
    GENDERLESS,

    @SerializedName("unknown")
    UNKNOWN
}

