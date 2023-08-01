package com.example.shiftsummer2023.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.example.shiftsummer2023.R
import com.example.shiftsummer2023.common.Constants
import com.example.shiftsummer2023.data.local.CharacterDatabase
import com.example.shiftsummer2023.data.local.entity.CharacterEntity
import com.example.shiftsummer2023.data.remote.CharacterRemoteMediator
import com.example.shiftsummer2023.data.remote.RickAndMortyApi
import com.example.shiftsummer2023.data.repository.CharacterRepositoryImpl
import com.example.shiftsummer2023.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideRickAndMortyApi(): RickAndMortyApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(RickAndMortyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCharacterDatabase(@ApplicationContext context: Context): CharacterDatabase {
        return Room.databaseBuilder(
            context,
            CharacterDatabase::class.java,
            "characters.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCharacterPager(
        characterDb: CharacterDatabase,
        characterApi: RickAndMortyApi
    ): Pager<Int, CharacterEntity> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = CharacterRemoteMediator(
                characterDb = characterDb,
                characterApi = characterApi
            ),
            pagingSourceFactory = {
                characterDb.dao.pagingSource()
            }
        )
    }


    @Provides
    @Singleton
    fun provideCharacterRepository(
        rickAndMortyApi: RickAndMortyApi
    ): CharacterRepository =
        CharacterRepositoryImpl(
            rickAndMortyApi = rickAndMortyApi
        )
}