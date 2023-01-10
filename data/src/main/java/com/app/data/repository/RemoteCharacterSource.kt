package com.app.data.repository

import com.app.data.model.CharacterDataModel

interface RemoteCharacterSource  {
    suspend fun getCharacters(page: Int) : List<CharacterDataModel>
}