package com.example.unidirectionalstateflow.data.local.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.unidirectionalstateflow.data.local.db.model.Clan

@Dao
interface ClanDao: DbDao<Clan>{
    @Query("SELECT * FROM TABLE_CLAN WHERE clanId = :id")
    fun getById(id: Long): LiveData<Clan>

    @Query("SELECT * FROM TABLE_CLAN")
    fun getAll(): LiveData<List<Clan>>
}