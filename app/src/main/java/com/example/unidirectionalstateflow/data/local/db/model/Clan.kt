package com.example.unidirectionalstateflow.data.local.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_clan")
data class Clan(@PrimaryKey val clanId: Long, val name: String) {

    companion object {
        fun ranDomClan(): Clan =
            Clan(Math.round(Math.random()), "")
    }
}