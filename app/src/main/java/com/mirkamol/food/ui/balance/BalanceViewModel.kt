package com.mirkamol.food.ui.balance

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mirkamol.food.data.local.entity.HistoryModel
import com.mirkamol.food.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BalanceViewModel @Inject constructor(private val repository: MainRepository):ViewModel() {
    fun addFood(food: HistoryModel) = viewModelScope.launch {
        repository.addFood(food)
    }
}