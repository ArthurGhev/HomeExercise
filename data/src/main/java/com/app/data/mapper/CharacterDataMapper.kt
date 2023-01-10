package com.app.data.mapper

import com.app.common.Mapper
import com.app.data.model.CharacterDataModel
import com.app.domain.entity.CharacterEntityModel
import javax.inject.Inject

class CharacterDataMapper @Inject constructor() : Mapper<CharacterDataModel, CharacterEntityModel> {
    override fun from(i: CharacterDataModel?): CharacterEntityModel {
        return CharacterEntityModel(
            name = i?.name,
            species = i?.species,
            gender = i?.species,
            image = i?.image
        )
    }

    override fun to(o: CharacterEntityModel?): CharacterDataModel {
        return CharacterDataModel(
            name = o?.name,
            species = o?.species,
            gender = o?.species,
            image = o?.image
        )
    }
}