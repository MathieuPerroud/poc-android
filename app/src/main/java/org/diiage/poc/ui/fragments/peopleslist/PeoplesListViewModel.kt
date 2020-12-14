package org.diiage.poc.ui.fragments.peopleslist

import androidx.hilt.lifecycle.ViewModelInject
import org.diiage.poc.common.mvi.MVIViewModel


class PeoplesListViewModel @ViewModelInject constructor() :
    MVIViewModel<PeoplesListState, PeoplesListIntent, PeoplesListPartialState, PeoplesListViewModel.Action>
        (PeoplesListReducer()) {

    override fun createInitialState(): PeoplesListState {
        TODO("Not yet implemented")
    }

    override fun intentToAction(intent: PeoplesListIntent): Action {
        TODO("Not yet implemented")
    }

    override fun handleAction(action: Action) {
        TODO("Not yet implemented")
    }

    sealed class Action {
        object Fetch : Action()
    }

}
