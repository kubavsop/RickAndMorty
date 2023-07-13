package com.example.shiftsummer2023.data.local.converters

import androidx.room.TypeConverter

class EpisodeListConverter {
    @TypeConverter
    fun fromEpisodeList(episodeList: List<String>): String {
        return episodeList.joinToString(",")
    }

    @TypeConverter
    fun toEpisodeList(episodeString: String): List<String> {
        return episodeString.split(",")
    }
}