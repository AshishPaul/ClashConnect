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

import com.example.unidirectionalstateflow.data.local.db.model.Clan

data class ClanListViewState(
    val clanListPageTitle : String = "",
    val adapterList: List<Clan>? = emptyList(),
    val showListLoading : Boolean = false,
    val showPageError : Boolean = false,
    val pageErrorText : String = "")

sealed class ClanListViewEffect{
    object NavigateToClanDetailsEffect : ClanListViewEffect()
    object ClanAddedEffect : ClanListViewEffect()
}

sealed class ClanListEvent{
    object LoadClanListEvent : ClanListEvent()
    data class AddClanEvent(val clan: Clan) : ClanListEvent()
}

