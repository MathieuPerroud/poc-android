package org.diiage.poc.common.mvi

interface IReducer<STATE, PARTIAL_STATE> {
    fun reduce(state: STATE, partialState: PARTIAL_STATE): STATE
}