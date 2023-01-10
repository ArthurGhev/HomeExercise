package com.app.presentation.mapper

import com.app.common.Mapper
import com.app.domain.entity.CharacterEntityModel
import com.app.presentation.model.CharacterUiModel
import javax.inject.Inject

class CharacterUiMapper @Inject constructor() : Mapper<CharacterEntityModel, CharacterUiModel> {
    override fun from(i: CharacterEntityModel?): CharacterUiModel {
        return CharacterUiModel(
            id = i?.id,
            name = i?.name,
            species = i?.species,
            gender = i?.species,
            image = i?.image
        )
    }

    override fun to(o: CharacterUiModel?): CharacterEntityModel {
        return CharacterEntityModel(
            id = o?.id,
            name = o?.name,
            species = o?.species,
            gender = o?.species,
            image = o?.image
        )
    }
}