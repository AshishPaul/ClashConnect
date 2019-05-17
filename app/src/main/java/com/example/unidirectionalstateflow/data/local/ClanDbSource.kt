package com.example.unidirectionalstateflow.data.local

import com.example.unidirectionalstateflow.data.local.model.Clan

interface ClanDbSource {
    fun saveClanList(clanList: List<Clan>)
    fun getClanList(): List<Clan>
}

class ClanClanDbSourceImpl : ClanDbSource {
    override fun getClanList(): List<Clan> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveClanList(clanList: List<Clan>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}