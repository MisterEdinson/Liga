package com.example.liga.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.liga.data.local.models.CompetitonModel
import com.example.liga.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository):ViewModel() {
    val ligsLiveData : MutableLiveData<List<CompetitonModel>> = MutableLiveData()

    init {
        getCompetitions()
    }
    private fun getCompetitions(){
        viewModelScope.launch {
            val responce = repository.getLeagues()
            ligsLiveData.value = responce
        }
    }
}