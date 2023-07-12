package com.example.liga.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Update
import com.example.liga.data.local.dao.*
import com.example.liga.data.local.models.*

@Database(
    entities = [
        CompetitonModel::class,
        LeagueInfoModel::class,
        TeamDaoModel::class,
        MatchesModel::class,
        UpdateDateModel::class],
    version = 1,
    exportSchema = false
)
abstract class LigaDao : RoomDatabase() {
    abstract fun Competitions(): CompetitionDao
    abstract fun Championship(): ChampionshipDao
    abstract fun Team(): TeamDao
    abstract fun Matches(): MatchesDao
    abstract fun UpdateTable(): UpdateDao
}