package com.mirkamol.food.repository

import com.mirkamol.food.data.local.dao.FoodDao
import com.mirkamol.food.data.local.entity.CreateFood
import com.mirkamol.food.data.local.entity.Food
import com.mirkamol.food.data.local.entity.HistoryModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(
    private val foodDao: FoodDao,
) {
    suspend fun addFood(food: HistoryModel) = foodDao.addFood(food)
    fun getFoodHistory() = foodDao.getFoodHistory()
    suspend fun addCreateFood(food: CreateFood) = foodDao.addCreateFood(food)
    fun getCreateFood() = foodDao.getCreateFood()

}