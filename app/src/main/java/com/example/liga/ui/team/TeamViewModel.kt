package com.example.liga.ui.team

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.liga.data.local.models.TeamDaoModel
import com.example.liga.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(private val repo:Repository) : ViewModel() {

    var teamInfo: MutableLiveData<TeamDaoModel> = MutableLiveData()

    fun getTeam(team_id:Int){
        viewModelScope.launch {
            val response = repo.getTeam(team_id)
            teamInfo.value = response
        }
    }
}