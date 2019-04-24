package com.example.unidirectionalstateflow.ui.modules.clans

import com.example.unidirectionalstateflow.data.model.Clan

data class ClanListViewState(
    val clanListPageTitle : String = "",
    val adapterList: List<Clan>? = emptyList(),
    val showListLoading : Boolean = false,
    val showPageError : Boolean = false,
    val pageErrorText : String = "")

sealed class ClanListViewEffect{
    object NavigateToClanDetailsEffect : ClanListViewEffect()
}

sealed class ClanListEvent{
    object ScreenLoadEvent : ClanListEvent()
    object AddItemToListEvent : ClanListEvent()
}

