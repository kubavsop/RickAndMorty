package com.example.shiftsummer2023.data

import com.google.gson.annotations.SerializedName

enum class CharacterGender {
    @SerializedName("Female")
    FEMALE,
    @SerializedName("Male")
    MALE,
    @SerializedName("Genderless")
    GENDERLESS,
    @SerializedName("unknown")
    UNKNOWN
}

