package com.example.shiftsummer2023.data.local.converters

import androidx.room.TypeConverter
import com.example.shiftsummer2023.data.local.entity.CharacterLocationEntity

class CharacterLocationConverter {
    @TypeConverter
    fun fromCharacterLocation(location: CharacterLocationEntity): String {
        return "${location.name},${location.url}"
    }

    @TypeConverter
    fun toCharacterLocation(locationString: String): CharacterLocationEntity {
        val parts = locationString.split(",")
        val name = parts[0]
        val url = parts[1]
        return CharacterLocationEntity(name, url)
    }
}