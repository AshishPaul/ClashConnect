package com.example.unidirectionalstateflow.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.unidirectionalstateflow.data.local.db.model.Clan

@Database(entities = [Clan::class], version = 1, exportSchema = false)
abstract class AppDataBase: RoomDatabase(){
    abstract fun clanDao(): ClanDao
}