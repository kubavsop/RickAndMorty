package com.example.shiftsummer2023.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.shiftsummer2023.data.local.entity.CharacterEntity

@Dao
interface CharacterDao {

    @Upsert
    suspend fun upsertAll(characters: List<CharacterEntity>)

    @Query("SELECT * FROM characterentity")
    fun pagingSource(): PagingSource<Int, CharacterEntity>

    @Query("DELETE FROM characterentity")
    suspend fun clearAll()
}