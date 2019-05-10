package com.example.unidirectionalstateflow.domain

import com.example.unidirectionalstateflow.data.model.Clan
import com.example.unidirectionalstateflow.data.source.local.LocalDbDataSource
import com.example.unidirectionalstateflow.data.source.local.SharedPrefsDataSource
import com.example.unidirectionalstateflow.data.source.remote.RemoteDataSource
import javax.inject.Inject

interface FetchClansUseCase {
    fun getClans() : List<Clan>
}

class FetchClansUseCaseImpl @Inject constructor(private val localDbDataSource: LocalDbDataSource,
                                                private val sharedPrefsDataSource: SharedPrefsDataSource,
                                                private val remoteDataSource: RemoteDataSource
) : FetchClansUseCase {
    override fun getClans(): List<Clan> {
        return mutableListOf()
    }
}