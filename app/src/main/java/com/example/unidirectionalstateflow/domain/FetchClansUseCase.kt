package com.example.unidirectionalstateflow.domain

import androidx.lifecycle.LiveData
import com.example.unidirectionalstateflow.data.local.db.model.Clan
import com.example.unidirectionalstateflow.data.repository.ClanRepository
import javax.inject.Inject

class FetchClansUseCase @Inject constructor(private val clanRepository: ClanRepository) {

    fun fetchClans() {
        clanRepository.fetchClans()
    }

    fun getClanList(): LiveData<List<Clan>> {
        return clanRepository.getClanList()
    }
}