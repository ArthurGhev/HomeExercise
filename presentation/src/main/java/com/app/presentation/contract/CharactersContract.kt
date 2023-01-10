package com.app.presentation.contract

import com.app.base.UiEffect
import com.app.base.UiEvent
import com.app.base.UiState

class CharactersContract {
    sealed class Event : UiEvent {
        data class GetCharacterstState(val page : Int) : Event()
    }

    data class State(
        val characterstState: CharacterstState
    ) : UiState

    data class SharedState(
        val characterstState: CharacterstState
    ) : UiState

    sealed class CharacterstState {
        object Idle : CharacterstState()
        object Loading : CharacterstState()
        data class Success(val count : Int) : CharacterstState()
    }

    sealed class Effect : UiEffect {
        data class ShowError(val message : String?) : Effect()
    }
}