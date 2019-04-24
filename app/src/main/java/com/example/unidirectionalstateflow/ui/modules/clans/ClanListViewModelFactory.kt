package com.example.unidirectionalstateflow.ui.modules.clans

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.unidirectionalstateflow.domain.FetchClansUseCase
import javax.inject.Inject

class ClanListViewModelFactory @Inject constructor(private val fetchClansUseCase: FetchClansUseCase): ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(ClanListViewModel::class.java)) {
                ClanListViewModel(this.fetchClansUseCase) as T
            } else {
                throw IllegalArgumentException("ViewModel Not Found")
            }
        }

    }