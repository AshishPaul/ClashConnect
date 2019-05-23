package com.example.unidirectionalstateflow.data.local.db

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface BaseDao<Entity> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: Entity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Entity>)

    @Query("SELECT * FROM TABLE_CLAN WHERE clanId = :id")
    fun getById(id: Long): LiveData<Entity>

    @Query("SELECT * FROM TABLE_CLAN")
    fun getAll(): LiveData<List<Entity>>
}