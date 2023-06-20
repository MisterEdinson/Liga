package com.example.liga.ui.cups

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.liga.data.local.models.LeagueChampGsonModel
import com.example.liga.data.local.models.LeaguesChampionsInfoModel
import com.example.liga.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CupsViewModel @Inject constructor(private val repo: Repository) : ViewModel() {
    val cupsInfo: MutableLiveData<LeaguesChampionsInfoModel> = MutableLiveData()
    val cupsTable: MutableLiveData<List<LeagueChampGsonModel>> = MutableLiveData()

    fun getCupsInfo(code: String) {
        viewModelScope.launch {
            val response = repo.getLeagueChampionsInfo(code)
            cupsInfo.value = response
        }
    }

    fun getCupsTable(code: String) {
        viewModelScope.launch {
            val responce = repo.getLeagueChampionsTable(code)
            cupsTable.value = responce
        }
    }
}