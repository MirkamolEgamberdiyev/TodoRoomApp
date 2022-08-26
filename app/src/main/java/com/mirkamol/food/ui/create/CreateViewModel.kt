package com.mirkamol.food.ui.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mirkamol.food.data.local.entity.CreateFood
import com.mirkamol.food.data.local.entity.Food
import com.mirkamol.food.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(private val repository: MainRepository):ViewModel() {
    var foodList = MutableLiveData<ArrayList<Food>>()


}