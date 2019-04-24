package com.example.unidirectionalstateflow.domain

import com.example.unidirectionalstateflow.domain.dataviewmodel.ClanDataViewModel

interface FetchClansUseCase {
    fun getClans() : List<ClanDataViewModel>
}