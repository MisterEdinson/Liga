package com.example.liga.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.liga.data.local.dao.ChampionshipDao
import com.example.liga.data.local.dao.CompetitionDao
import com.example.liga.data.local.dao.TeamDao
import com.example.liga.data.local.models.CompetitonModel
import com.example.liga.data.local.models.LeagueInfoModel
import com.example.liga.data.local.models.TeamDaoModel

@Database(
    entities = [
        CompetitonModel::class,
        LeagueInfoModel::class,
        TeamDaoModel::class],
    version = 1,
    exportSchema = false
)
abstract class LigaDao : RoomDatabase() {
    abstract fun Competitions(): CompetitionDao
    abstract fun Championship(): ChampionshipDao
    abstract fun Team(): TeamDao
}