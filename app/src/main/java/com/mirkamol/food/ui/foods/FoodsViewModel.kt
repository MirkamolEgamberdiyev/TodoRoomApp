package com.mirkamol.food.ui.foods

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mirkamol.food.data.local.entity.CreateFood
import com.mirkamol.food.data.local.entity.Food
import com.mirkamol.food.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodsViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {
    fun getCreateFood(): LiveData<List<CreateFood>> {
        return repository.getCreateFood()
    }
}