package com.example.liga.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.liga.data.local.models.CompetitonModel
import com.example.liga.data.local.models.MatchesDaoModel
import com.example.liga.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val ligsLiveData: MutableLiveData<List<CompetitonModel>> = MutableLiveData()
    val matchDayLiveData: MutableLiveData<MatchesDaoModel> = MutableLiveData()

    init {
        getCompetitions()
        getMatchDay()
    }

    private fun getCompetitions() {
        viewModelScope.launch {
            val responce = repository.getLeagues()
            ligsLiveData.value = responce
        }
    }

    private fun getMatchDay() {
        viewModelScope.launch {
            val response = repository.getMatchDay()
            matchDayLiveData.value = response
        }
    }
}