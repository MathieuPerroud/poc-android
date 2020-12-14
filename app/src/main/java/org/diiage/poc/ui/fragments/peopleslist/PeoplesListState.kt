package org.diiage.poc.ui.fragments.peopleslist

import org.diiage.poc.ui.models.VPeople

data class PeoplesListState(
    val list: List<VPeople> = emptyList()
)