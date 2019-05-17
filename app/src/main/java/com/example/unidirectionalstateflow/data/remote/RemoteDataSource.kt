package com.example.unidirectionalstateflow.data.remote

import com.example.unidirectionalstateflow.data.remote.model.FetchClanListResponse

interface RemoteDataSource {
    fun fetchClans(): FetchClanListResponse
}

class RemoteDataSourceImpl : RemoteDataSource {
    override fun fetchClans(): FetchClanListResponse {
        return FetchClanListResponse(listOf())
    }
}