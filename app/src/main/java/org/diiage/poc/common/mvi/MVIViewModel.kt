package org.diiage.poc.common.mvi

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

abstract class MVIViewModel<State, Intent, PartialState, Action> constructor(
    stateReducer: IReducer<State, PartialState>,
    initialAction: Action? = null
) :
    StateIntentViewModel<State, Intent>() {

    protected val stateChannel = Channel<PartialState>()

    private val reducer: IReducer<State, PartialState> =
        stateReducer

    init {
        launch(Dispatchers.Main) {
            for (partialState in stateChannel) {
                _state.value = reducer.reduce(_state.value, partialState)
            }
        }
        if (initialAction != null) {
            launch {
                handleAction(initialAction)
            }
        }
    }

    override fun dispatchIntent(intent: Intent) =
        intentToAction(intent).forEach { action ->
            handleAction(action)
        }

    protected abstract fun intentToAction(intent: Intent): Array<Action>

    protected abstract fun handleAction(action: Action)

}
