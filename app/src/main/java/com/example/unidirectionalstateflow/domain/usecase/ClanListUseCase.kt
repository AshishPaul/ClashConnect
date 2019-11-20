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

package com.example.unidirectionalstateflow.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.liveData
import com.example.unidirectionalstateflow.data.local.db.model.Clan
import com.example.unidirectionalstateflow.data.repository.ClanRepository
import com.example.unidirectionalstateflow.domain.Action
import com.example.unidirectionalstateflow.domain.ClanAction
import com.example.unidirectionalstateflow.domain.ClanResult
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class ClanListUseCase @Inject constructor(private val clanRepository: ClanRepository) :
    Dispatcher<ClanResult> {

    override fun dispatchAction(action: Action): LiveData<ClanResult> = liveData(Dispatchers.IO) {
        when (action) {
            is ClanAction.GetClanListAction -> {
                emit(ClanResult.Loading)

                val dataResult = clanRepository.loadClans()
                if (dataResult is ClanResult.Error) {
                    emit(dataResult)
                } else {
                    emitSource(Transformations.map(clanRepository.getClanList()) {
                        ClanResult.Success(it)
                    })

                }
            }
        }
    }

    suspend fun process(action: ClanAction.GetClanListAction): ClanResult =
        clanRepository.loadClans()


    suspend fun addClan(clan: Clan) {
        clanRepository.addClan(clan)
    }
}
