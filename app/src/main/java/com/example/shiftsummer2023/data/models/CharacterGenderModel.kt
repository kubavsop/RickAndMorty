package com.example.shiftsummer2023.data.models

import com.google.gson.annotations.SerializedName

enum class CharacterGenderModel {
    @SerializedName("Female")
    FEMALE,
    @SerializedName("Male")
    MALE,
    @SerializedName("Genderless")
    GENDERLESS,
    @SerializedName("unknown")
    UNKNOWN
}

