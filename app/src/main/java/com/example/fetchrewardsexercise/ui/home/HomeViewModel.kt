package com.example.fetchrewardsexercise.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchrewardsexercise.api.NetworkResult
import com.example.fetchrewardsexercise.repo.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: Repo
):  ViewModel(){
    private val _data: MutableStateFlow<List<HiringUIModel>?> = MutableStateFlow(null)
    val data: StateFlow<List<HiringUIModel>?> = _data.asStateFlow()

    fun fetchData() {
        viewModelScope.launch {
            val response = repo.getData()
            val dataList = mutableListOf<HiringUIModel>()
            if (response is NetworkResult.Success) {
                val dataFromRepo = response.data.orEmpty()
                dataFromRepo.forEach {
                    if (!it.name.isNullOrEmpty()) {
                        dataList.add(dataToHiringUI(it))
                    }
                }
                dataList.sortWith(
                    compareBy({ it.listId }, { it.name })
                )
                _data.value = dataList
            } else if (response is NetworkResult.Error) {
                Timber.d("Error: ${response.message}")
            }
        }
    }

}