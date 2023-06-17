package com.example.liga.ui.ligs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.liga.data.local.models.LeagueInfoModel
import com.example.liga.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeagueViewModel @Inject constructor(private val repo: Repository) : ViewModel() {
    val infoLeague: MutableLiveData<LeagueInfoModel> = MutableLiveData()

    init {
        getInfoLeague()
    }

    fun getInfoLeague() {
        viewModelScope.launch {
            val leagueInfo = repo.getLeagueInfo()
            infoLeague.value = leagueInfo
        }
    }
}