package com.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.app.common.Mapper
import com.app.domain.entity.CharacterEntityModel
import com.app.domain.usecase.GetCharactersUseCase
import com.app.presentation.model.CharacterUiModel
import com.app.presentation.paging.CharactersPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel@Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val userMapper : Mapper<CharacterEntityModel, CharacterUiModel>
) : ViewModel() {

    val characters = Pager(PagingConfig(1)) {
        CharactersPagingSource(getCharactersUseCase, userMapper)
    }.flow.cachedIn(viewModelScope)
}