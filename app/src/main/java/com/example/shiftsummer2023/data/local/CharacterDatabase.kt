package com.example.shiftsummer2023.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.shiftsummer2023.data.local.converters.CharacterLocationConverter
import com.example.shiftsummer2023.data.local.converters.EpisodeListConverter
import com.example.shiftsummer2023.data.local.entity.CharacterEntity

@Database(
    entities = [CharacterEntity::class],
    version = 1
)
@TypeConverters(CharacterLocationConverter::class, EpisodeListConverter::class)
abstract class CharacterDatabase : RoomDatabase() {
    abstract val dao: CharacterDao
}