package com.app.data.repository

import com.app.common.Mapper
import com.app.data.model.CharacterDataModel
import com.app.domain.entity.CharacterEntityModel
import com.app.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val remoteUserSource: RemoteCharacterSource,
    private val userMapper: Mapper<CharacterDataModel, CharacterEntityModel>
    ) : CharacterRepository{
    override suspend fun getCharacterPaging(page: Int): List<CharacterEntityModel> {
        return userMapper.fromList(remoteUserSource.getCharacters(page))
    }
}