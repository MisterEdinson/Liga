package com.example.liga.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.liga.data.local.models.CompetitonModel
import com.example.liga.data.local.models.MatchesModel
import com.example.liga.data.local.models.MatchesDaoModel
import com.example.liga.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val ligsLiveData: MutableLiveData<List<CompetitonModel>> = MutableLiveData()
    val matchDayLiveData: MutableLiveData<List<MatchesModel>> = MutableLiveData()
    val matchImmediateLiveData: MutableLiveData<List<MatchesModel>> = MutableLiveData()

    init {
        getCompetitions()
    }

    fun getCompetitions() {
        viewModelScope.launch {
            val responce = repository.getLeagues()
            ligsLiveData.value = responce
        }
    }

    fun getMatchDay() {
        viewModelScope.launch {
            val response = repository.getMatchDay()
            matchDayLiveData.value = response
        }
    }

    fun getImmediateDay(){
        viewModelScope.launch {
            val response = repository.getMatchImmediate()
            matchImmediateLiveData.value = response
        }
    }
}