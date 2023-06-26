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
    val getChampionship: MutableLiveData<LeagueInfoModel> = MutableLiveData()

    fun getTableChampionship(code:String){
        viewModelScope.launch {
            val response = repo.getLeagueTable(code)
            getChampionship.value = response
        }
    }
}