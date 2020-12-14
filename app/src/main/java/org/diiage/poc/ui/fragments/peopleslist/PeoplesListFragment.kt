package org.diiage.poc.ui.fragments.peopleslist

import dagger.hilt.android.AndroidEntryPoint
import org.diiage.poc.R
import org.diiage.poc.BR
import org.diiage.poc.common.mvi.MVIFragment
import org.diiage.poc.databinding.PeoplesListFragmentBinding

@AndroidEntryPoint
class PeoplesListFragment :
    MVIFragment<PeoplesListState,PeoplesListIntent, PeoplesListFragmentBinding,PeoplesListViewModel>(
        R.layout.peoples_list_fragment,
        BR.viewmodel
    ) {

    override fun setupViews() {

    }

    override fun renderState(viewState: PeoplesListState) {
        viewBinding.executePendingBindings()
    }
}