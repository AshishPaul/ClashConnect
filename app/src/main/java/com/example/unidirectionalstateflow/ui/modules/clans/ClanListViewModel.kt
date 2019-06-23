package com.example.unidirectionalstateflow.ui.modules.clans

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.unidirectionalstateflow.data.local.db.model.Clan
import com.example.unidirectionalstateflow.domain.FetchClansUseCase
import com.example.unidirectionalstateflow.ui.BaseViewModel
import javax.inject.Inject

class ClanListViewModel @Inject constructor(private val fetchClansUseCase: FetchClansUseCase) :
    BaseViewModel<ClanListViewState, ClanListViewEffect, ClanListEvent>() {

    private var clanListLiveData: LiveData<List<Clan>> = fetchClansUseCase.getClanList()
    private val viewStateMLD = Transformations
        .map(clanListLiveData) { clanList -> {
            when(clanList) {
                null || size==0 ->
                    ClanListViewState(
                        adapterList = clanList
                    )
            }
        }
    }
    private val viewEffectMLD = MutableLiveData<ClanListViewEffect>()

    val viewStateLiveData: LiveData<ClanListViewState>
        get() = viewStateMLD
    val viewEffectLiveData: LiveData<ClanListViewEffect>
        get() = viewEffectMLD

    override fun processEvent(viewEvent: ClanListEvent) {
        when (viewEvent) {
            is ClanListEvent.ScreenLoadEvent -> onScreenLoadEvent()
            is ClanListEvent.AddItemToListEvent -> onAddItemToListEvent()
        }
    }

    private fun onAddItemToListEvent() {
        viewStateMLD.apply {
            postValue(value?.copy(adapterList = value?.adapterList?.plus(Clan.ranDomClan())))
        }
    }

    private fun onScreenLoadEvent() {
        fetchClansUseCase.loadClans()
        viewStateMLD.postValue(
            ClanListViewState(
                adapterList = listOf(
                    Clan(1, "One"),
                    Clan(2, "Two")
                )
            )
        )
    }

    val square: (Int) -> Unit = { }

    fun testLamda() {


        val nine = square(7)
        passMeFunction(square)
    }

    fun passMeFunction(abc: (Int) -> Unit) {
        abc(8)
    }


}
