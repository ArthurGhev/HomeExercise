package com.app.domain.usecase

import com.app.domain.entity.CharacterEntityModel
import com.app.domain.repository.CharacterRepository
import javax.inject.Inject

class GetCharactersUseCase  @Inject constructor(
    private val repository: CharacterRepository
) : BaseUseCase<List<CharacterEntityModel>, Int>() {

    override suspend fun buildRequest(page: Int): List<CharacterEntityModel> {
        return repository.getCharacterPaging(page)
    }
}