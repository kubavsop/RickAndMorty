package com.example.shiftsummer2023.di

import com.example.shiftsummer2023.domain.repository.CharacterRepository
import com.example.shiftsummer2023.domain.usecase.GetCharacterByIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {
    @Provides
    fun provideGetCharacterByIdUseCase(repository: CharacterRepository): GetCharacterByIdUseCase {
        return GetCharacterByIdUseCase(repository = repository)
    }
}