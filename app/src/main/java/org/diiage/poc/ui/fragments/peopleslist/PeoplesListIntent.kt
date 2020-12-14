package org.diiage.poc.ui.fragments.peopleslist

sealed class PeoplesListIntent {
    object RefreshView : PeoplesListIntent()
}