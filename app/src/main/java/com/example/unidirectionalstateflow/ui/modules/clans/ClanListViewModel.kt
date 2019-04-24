package com.example.unidirectionalstateflow.ui.modules.clans

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.unidirectionalstateflow.data.model.Clan
import com.example.unidirectionalstateflow.domain.FetchClansUseCase
import com.example.unidirectionalstateflow.ui.BaseViewModel
import javax.inject.Inject

class ClanListViewModel @Inject constructor(private val fetchClansUseCase: FetchClansUseCase) :
    BaseViewModel<ClanListViewState, ClanListViewEffect, ClanListEvent>() {

    private val _viewStateLiveData = MutableLiveData<ClanListViewState>().apply {
        postValue(
            ClanListViewState(
                adapterList = listOf(
                    Clan(1, "One"),
                    Clan(2, "Two")
                )
            )
        )
    }

    val viewStateLiveData: LiveData<ClanListViewState>
        get() = _viewStateLiveData

    private val _viewEffectLiveData = MutableLiveData<ClanListViewEffect>()
    val viewEffectLiveData: LiveData<ClanListViewEffect>
        get() = _viewEffectLiveData

    override fun processInput(viewEvent: ClanListEvent) {
        when (viewEvent) {
            is ClanListEvent.AddItemToListEvent ->
                _viewStateLiveData.apply {
                    postValue(value?.copy(adapterList = value?.adapterList?.plus(Clan.ranDomClan())))

                }
        }

    }


}
