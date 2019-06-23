package com.example.unidirectionalstateflow.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.unidirectionalstateflow.data.local.db.model.Clan
import com.example.unidirectionalstateflow.data.repository.ClanRepository
import javax.inject.Inject

class FetchClansUseCase @Inject constructor(private val clanRepository: ClanRepository) {

    val clanList
    fun loadClans() {
        clanRepository.loadClans()
    }

    fun getClanList(): LiveData<List<Clan>> {
         Transformations.clanRepository.getClanList()

    }
}