package com.example.unidirectionalstateflow.data.local.db

import androidx.room.Dao
import com.example.unidirectionalstateflow.data.local.db.model.Clan

@Dao
interface ClanDao: BaseDao<Clan>