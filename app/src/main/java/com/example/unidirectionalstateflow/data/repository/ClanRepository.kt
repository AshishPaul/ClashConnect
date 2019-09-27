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

package com.example.unidirectionalstateflow.data.repository

import androidx.lifecycle.LiveData
import com.example.unidirectionalstateflow.data.local.db.ClanDao
import com.example.unidirectionalstateflow.data.local.db.model.Clan
import com.example.unidirectionalstateflow.data.remote.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ClanRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val clanDao: ClanDao
) {

    fun getClanList(): LiveData<List<Clan>> = clanDao.getAll()

    suspend fun loadClans() {
        withContext(Dispatchers.IO) {
            val fetchClanListResponse = remoteDataSource.fetchClans()
            clanDao.insertAll(fetchClanListResponse.data)
        }
    }

    suspend fun addClan(clan: Clan) {
        withContext(Dispatchers.IO) {
            clanDao.insert(clan)
        }
    }
}
