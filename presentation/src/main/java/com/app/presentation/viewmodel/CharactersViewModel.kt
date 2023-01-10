package com.app.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.app.base.BaseViewModel
import com.app.base.UiState
import com.app.domain.usecase.GetCharactersUseCase
import com.app.presentation.contract.CharactersContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel@Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
)  : BaseViewModel<CharactersContract.Event, UiState, CharactersContract.Effect>() {
    override fun createInitialState(): CharactersContract.State {
        return CharactersContract.State(
            characterstState = CharactersContract.CharacterstState.Idle
        )
    }

    override fun handleEvent(event: CharactersContract.Event) {
        when (event) {
            is CharactersContract.Event.GetCharacterstState -> {
                getCharactersRepoCount(event.page)
            }
        }
    }

    fun getCharactersRepoCount(page: Int) {
        viewModelScope.launch {
            val a = getCharactersUseCase.buildRequest(page)
            Log.d("testUseCase", " a -> ${a.size}")
        }
    }
}