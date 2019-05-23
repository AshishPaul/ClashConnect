package com.example.unidirectionalstateflow.data.repository

import androidx.lifecycle.LiveData
import com.example.unidirectionalstateflow.data.local.db.ClanDao
import com.example.unidirectionalstateflow.data.local.db.model.Clan
import com.example.unidirectionalstateflow.data.remote.RemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ClanRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val clanDao: ClanDao
) {

    fun getClanList(): LiveData<List<Clan>> = clanDao.getAll()

    fun fetchClans() {
        val fetchClanListResponse = remoteDataSource.fetchClans()
        clanDao.insertAll(fetchClanListResponse.clanList)
    }
}
