package com.example.unidirectionalstateflow.data.remote.model

import com.example.unidirectionalstateflow.data.local.model.Clan

data class FetchClanListResponse(val clanList: List<Clan>) : BaseResponse()