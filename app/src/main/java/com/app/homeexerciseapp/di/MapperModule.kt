package com.app.homeexerciseapp.di

import com.app.common.Mapper
import com.app.data.mapper.CharacterDataMapper
import com.app.data.model.CharacterDataModel
import com.app.domain.entity.CharacterEntityModel
import com.app.presentation.mapper.CharacterUiMapper
import com.app.presentation.model.CharacterUiModel
import com.app.remote.mapper.CharacterRemoteMapper
import com.app.remote.model.ResultsModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun bindsUserRemoteMapper(mapper: CharacterRemoteMapper) : Mapper<ResultsModel, CharacterDataModel>

    @Binds
    abstract fun bindsUserDomainMapper(mapper: CharacterDataMapper) : Mapper<CharacterDataModel, CharacterEntityModel>

    @Binds
    abstract fun bindsUserDomainUiMapper(mapper : CharacterUiMapper) : Mapper<CharacterEntityModel, CharacterUiModel>

}