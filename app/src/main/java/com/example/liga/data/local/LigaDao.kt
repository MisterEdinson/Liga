package com.example.liga.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.liga.data.local.dao.ChampionshipDDao
import com.example.liga.data.local.dao.CompetitionDao
import com.example.liga.data.local.dao.InfoUpdatedDao
import com.example.liga.data.local.models.CompetitonModel
import com.example.liga.data.local.models.LeagueInfoModel
import com.example.liga.data.local.models.LeagueUpdateInfoModel

@Database(
    entities = [
        CompetitonModel::class,
        LeagueInfoModel::class],
    version = 1,
    exportSchema = false
)
abstract class LigaDao : RoomDatabase() {
    abstract fun ligaCompetitionDao(): CompetitionDao
    abstract fun leagueChampionship(): ChampionshipDDao
}