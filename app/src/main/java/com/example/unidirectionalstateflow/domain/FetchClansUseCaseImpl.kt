package com.example.unidirectionalstateflow.domain

import com.example.unidirectionalstateflow.data.LocalDbDataSource
import com.example.unidirectionalstateflow.data.RemoteDataSource
import com.example.unidirectionalstateflow.data.SharedPrefsDataSource
import com.example.unidirectionalstateflow.domain.FetchClansUseCase
import com.example.unidirectionalstateflow.domain.dataviewmodel.ClanDataViewModel
import javax.inject.Inject

class FetchClansUseCaseImpl @Inject constructor(private val localDbDataSource: LocalDbDataSource,
                                                private val sharedPrefsDataSource: SharedPrefsDataSource,
                                                private val remoteDataSource: RemoteDataSource
) : FetchClansUseCase {
    override fun getClans(): List<ClanDataViewModel> {
        return mutableListOf()
    }
}