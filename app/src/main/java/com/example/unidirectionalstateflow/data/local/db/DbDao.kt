package com.example.unidirectionalstateflow.data.local.db

import androidx.room.Insert
import androidx.room.OnConflictStrategy

interface DbDao<Entity> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: Entity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Entity>)


}