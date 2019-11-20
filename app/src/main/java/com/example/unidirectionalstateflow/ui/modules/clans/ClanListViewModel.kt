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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unidirectionalstateflow.data.local.db.model.Clan
import com.example.unidirectionalstateflow.domain.ClanAction
import com.example.unidirectionalstateflow.domain.ClanResult
import com.example.unidirectionalstateflow.domain.ErrorHandler
import com.example.unidirectionalstateflow.domain.usecase.ClanListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ClanListViewModel @Inject constructor(
    private val fetchClanListUseCase: ClanListUseCase,
    private val errorHandler: ErrorHandler
) : ViewModel() {

    private val viewEffectMLD = MutableLiveData<ClanListViewEffect>()
    private val viewStateMLD = MutableLiveData<ClanListViewState>()

    val viewEffect: LiveData<ClanListViewEffect>
        get() = viewEffectMLD
    val viewState: LiveData<ClanListViewState>
        get() = viewStateMLD

    private var currentViewState = ClanListViewState()
        set(value) {
            field = value
            viewStateMLD.value = value
        }

    fun processEvent(event: ClanListEvent) {
        when (event) {
            is ClanListEvent.LoadClanListEvent -> {
                loadClanList()
            }

            is ClanListEvent.AddClanEvent -> {
                addClan(event.clan)
            }
        }
    }

    private fun addClan(clan: Clan) {
        viewModelScope.launch {
            fetchClanListUseCase.addClan(clan)

            resultToViewEffect(ClanResult.AddSuccess)
        }
    }

    private fun resultToViewEffect(result: ClanResult) {
        when (result) {
            is ClanResult.AddSuccess -> viewEffectMLD.value = ClanListViewEffect.ClanAddedEffect
        }
    }

    private fun resultToViewState(result: ClanResult) {
        when (result) {
            is ClanResult.Loading -> currentViewState.copy(showListLoading = true)
            is ClanResult.Success -> currentViewState.copy(
                showListLoading = false,
                adapterList = result.data,
                pageErrorText = ""
            )
            is ClanResult.Error -> currentViewState.copy(
                showListLoading = false,
                pageErrorText = errorHandler.getDisplayErrorMsg(result.errorCode)
            )
        }
    }

    private fun loadClanList() {
        viewModelScope.launch {
            resultToViewState(ClanResult.Loading)
            val result = fetchClanListUseCase.process(ClanAction.GetClanListAction)

//            if (dataResult is ClanResult.Error) {
//                emit(dataResult)
//            }
        }
//        Transformations.map() {
//            resultToViewState(it)
//        }
    }
}