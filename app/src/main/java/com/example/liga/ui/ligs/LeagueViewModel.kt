package com.example.liga.ui.ligs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.liga.data.local.models.LeagueInfoModel
import com.example.liga.data.local.models.LeaguesTableModel
import com.example.liga.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeagueViewModel @Inject constructor(private val repo: Repository) : ViewModel() {
    val infoLeague: MutableLiveData<LeagueInfoModel> = MutableLiveData()
    val tableLeague : MutableLiveData<List<LeaguesTableModel>> = MutableLiveData()

    fun getInfoLeague(code:String) {
        viewModelScope.launch {
            val leagueInfo = repo.getLeagueInfo(code)
            infoLeague.value = leagueInfo
        }
    }
    fun getLeagueTable(code: String){
        viewModelScope.launch {
            val leagueTable = repo.getLeagueTable(code)
            tableLeague.value = leagueTable
        }
    }
}