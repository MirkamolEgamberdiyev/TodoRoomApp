package com.mirkamol.food.ui.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mirkamol.food.data.local.entity.HistoryModel
import com.mirkamol.food.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    fun getAllFood(): LiveData<List<HistoryModel>> {
        return repository.getAllFood()
    }
    fun deleteFood(food: HistoryModel) = viewModelScope.launch {
        repository.deleteFood(food)
    }

    fun deleteAllFood() = viewModelScope.launch {
        repository.deleteAllFood()
    }
}