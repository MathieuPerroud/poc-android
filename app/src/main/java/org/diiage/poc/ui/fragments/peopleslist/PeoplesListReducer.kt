package org.diiage.poc.ui.fragments.peopleslist

import org.diiage.poc.common.mvi.IReducer

class PeoplesListReducer : IReducer<PeoplesListState, PeoplesListPartialState> {
    override fun reduce(
        state: PeoplesListState,
        partialState: PeoplesListPartialState
    ): PeoplesListState {
        return PeoplesListState()
    }
}