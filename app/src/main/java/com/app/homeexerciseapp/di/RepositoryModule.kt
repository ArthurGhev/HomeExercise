package com.app.homeexerciseapp.di

import com.app.data.repository.CharacterRepositoryImpl
import com.app.data.repository.RemoteCharacterSource
import com.app.domain.repository.CharacterRepository
import com.app.remote.source.RemoteCharacterImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideLocalDataSource(localDataSourceImpl: RemoteCharacterImp): RemoteCharacterSource

    @Binds
    @ViewModelScoped
    abstract fun provideUserRepository(repository: CharacterRepositoryImpl): CharacterRepository
}