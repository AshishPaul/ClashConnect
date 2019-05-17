package com.example.unidirectionalstateflow.domain

import com.example.unidirectionalstateflow.data.local.model.Clan
import com.example.unidirectionalstateflow.data.remote.model.FetchClanListResponse
import com.example.unidirectionalstateflow.data.local.ClanDbSource
import com.example.unidirectionalstateflow.data.local.SharedPrefsSource
import com.example.unidirectionalstateflow.data.remote.RemoteDataSource
import javax.inject.Inject

class FetchClansUseCase @Inject constructor(private val remoteDataSource: RemoteDataSource,
                                            private val clanDbSource: ClanDbSource,
                                            private val sharedPrefsSource: SharedPrefsSource
) : UseCase() {

    override fun processAction(action: Action)  {
    }

    private fun fetchClansFromRemote() {
        val fetchClanListResponse: FetchClanListResponse = remoteDataSource.fetchClans()
        clanDbSource.saveClanList(fetchClanListResponse.clanList)
    }

    private fun getClanList(): List<Clan> {
        return clanDbSource.getClanList()
    }
}