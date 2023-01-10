package com.app.remote.mapper

import com.app.common.Mapper
import com.app.data.model.CharacterDataModel
import com.app.remote.model.ResultsModel
import javax.inject.Inject

class CharacterRemoteMapper @Inject constructor() : Mapper<ResultsModel, CharacterDataModel> {
    override fun from(i: ResultsModel?): CharacterDataModel {
        return CharacterDataModel(
            name = i?.name,
            species = i?.species,
            gender = i?.species,
            image = i?.image
        )
    }

    override fun to(o: CharacterDataModel?): ResultsModel {
        return ResultsModel(
            id = null,
            name = o?.name,
            status = null,
            species = o?.species,
            type = null,
            gender = o?.species,
            origin = null,
            location = null,
            image = o?.image,
            episode = null,
            url = null,
            created = null
        )
    }
}