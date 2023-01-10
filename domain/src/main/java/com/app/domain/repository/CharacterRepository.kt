package com.app.domain.repository

import com.app.domain.entity.CharacterEntityModel

interface CharacterRepository {
    suspend fun getCharacterPaging(page: Int) : List<CharacterEntityModel>
}