package com.app.remote.source

import com.app.common.Mapper
import com.app.data.model.CharacterDataModel
import com.app.data.repository.RemoteCharacterSource
import com.app.remote.api.ApiService
import com.app.remote.model.ResultsModel
import javax.inject.Inject

class RemoteCharacterImp @Inject constructor(
    private val apiService: ApiService,
    private val getCharacterMapper: Mapper<ResultsModel, CharacterDataModel>,
) : RemoteCharacterSource{

    override suspend fun getCharacters(page: Int): List<CharacterDataModel> {
        return getCharacterMapper.fromList(apiService.getCharacter(page).resultsBean)
    }

    override suspend fun getCharacter(name: String): CharacterDataModel {
        TODO("Not yet implemented")
    }
}