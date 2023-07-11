package com.example.shiftsummer2023.di

import com.example.shiftsummer2023.domain.repository.CharacterRepository
import com.example.shiftsummer2023.domain.usecase.GetFirstPageUseCase
import com.example.shiftsummer2023.domain.usecase.GetPageByUrlUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetFirstPageUseCase(repository: CharacterRepository): GetFirstPageUseCase =
        GetFirstPageUseCase(repository = repository)

    @Provides
    fun provideGetPageByUrlUseCase(repository: CharacterRepository): GetPageByUrlUseCase =
        GetPageByUrlUseCase(repository = repository)
}