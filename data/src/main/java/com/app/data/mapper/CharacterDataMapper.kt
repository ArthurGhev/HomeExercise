package com.app.data.mapper

import com.app.common.Mapper
import com.app.data.model.CharacterDataModel
import com.app.domain.entity.CharacterEntityModel
import javax.inject.Inject

class CharacterDataMapper @Inject constructor() : Mapper<CharacterDataModel, CharacterEntityModel> {
    override fun from(i: CharacterDataModel?): CharacterEntityModel {
        return CharacterEntityModel(
            id = i?.id,
            name = i?.name,
            species = i?.species,
            gender = i?.gender,
            image = i?.image
        )
    }

    override fun to(o: CharacterEntityModel?): CharacterDataModel {
        return CharacterDataModel(
            id = o?.id,
            name = o?.name,
            species = o?.species,
            gender = o?.gender,
            image = o?.image
        )
    }
}