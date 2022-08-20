package com.mirkamol.food.repository
import com.mirkamol.food.data.local.dao.FoodDao
import com.mirkamol.food.data.local.entity.Food
import com.mirkamol.food.data.local.entity.HistoryModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(
    private val foodDao: FoodDao,
) {
    suspend fun addFood(food: HistoryModel) = foodDao.addFood(food)
    suspend fun addFoods(food: Food) = foodDao.addFoods(food)
    fun getAllFood() = foodDao.getFoods()
    fun getAllFoods() = foodDao.getAllFoods()
    suspend fun deleteFood(food: HistoryModel) = foodDao.deleteData(food)
    suspend fun deleteAllFood() = foodDao.deleteAll()

}