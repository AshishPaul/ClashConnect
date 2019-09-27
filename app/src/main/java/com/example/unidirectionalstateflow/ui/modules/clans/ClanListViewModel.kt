/*
 * Copyright (c) Ashish , 2019
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.unidirectionalstateflow.ui.modules.clans

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.unidirectionalstateflow.data.local.db.model.Clan
import com.example.unidirectionalstateflow.domain.FetchClansUseCase
import com.example.unidirectionalstateflow.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class ClanListViewModel @Inject constructor(private val fetchClansUseCase: FetchClansUseCase) :
    BaseViewModel<ClanListViewState, ClanListViewEffect, ClanListEvent>() {

    private val viewStateMLD = MutableLiveData<ClanListViewState>()
    private val viewEffectMLD = MutableLiveData<ClanListViewEffect>()

    val viewState: LiveData<ClanListViewState>
        get() = Transformations
            .map(fetchClansUseCase.getClanList()) {
                ClanListViewState(adapterList = it)
            }
    val viewEffect: LiveData<ClanListViewEffect>
        get() = MutableLiveData<ClanListViewEffect>()

    override fun processEvent(viewEvent: ClanListEvent) {
        when (viewEvent) {
            is ClanListEvent.ScreenLoadEvent -> onScreenLoadEvent()
            is ClanListEvent.AddItemToListEvent -> onAddItemToListEvent(viewEvent.clan)
        }
    }

    private fun onAddItemToListEvent(clan: Clan) {
        viewModelScope.launch { fetchClansUseCase.addClan(clan) }
    }

    private fun onScreenLoadEvent() {
        viewModelScope.launch { fetchClansUseCase.loadClans() }
    }
}
