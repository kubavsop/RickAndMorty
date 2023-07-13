package com.example.shiftsummer2023.di

import android.content.Context
import com.example.shiftsummer2023.R
import com.example.shiftsummer2023.data.api.RickAndMortyApi
import com.example.shiftsummer2023.data.dto.CharactersConverter
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

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideRickAndMortyApi(@ApplicationContext context: Context): RickAndMortyApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(context.getString(R.string.server_url))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(RickAndMortyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCharacterConverter(): CharactersConverter = CharactersConverter()

    @Provides
    @Singleton
    fun provideCharacterRepository(
        charactersConverter: CharactersConverter,
        rickAndMortyApi: RickAndMortyApi
    ): CharacterRepository =
        CharacterRepositoryImpl(
            charactersConverter = charactersConverter,
            rickAndMortyApi = rickAndMortyApi
        )
}