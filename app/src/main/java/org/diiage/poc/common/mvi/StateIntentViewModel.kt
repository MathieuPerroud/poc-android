package org.diiage.poc.common.mvi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.coroutines.CoroutineContext

abstract class StateIntentViewModel<State,Intent>: ViewModel(), IModel<State, Intent>, CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Default

    protected val _state =
        MutableStateFlow(createInitialState())
    override val state: StateFlow<State>
        get() = _state

    abstract fun createInitialState() : State
    abstract override fun dispatchIntent(intent: Intent)
}
