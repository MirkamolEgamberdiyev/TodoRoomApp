package com.mirkamol.food.ui.addfood

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mirkamol.food.data.local.entity.Food
import com.mirkamol.food.data.local.entity.HistoryModel
import com.mirkamol.food.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class AddViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {
    fun addFood(food: Food) = viewModelScope.launch {
        repository.addFoods(food)
    }

    fun getAllFoods(): LiveData<List<Food>> {
        return repository.getAllFoods()
    }



}