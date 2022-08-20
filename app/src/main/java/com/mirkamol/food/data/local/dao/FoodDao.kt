package com.mirkamol.food.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mirkamol.food.data.local.entity.Food
import com.mirkamol.food.data.local.entity.HistoryModel

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFood(food: HistoryModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFoods(food: Food)

    @Delete(entity = HistoryModel::class)
    suspend fun deleteData(food: HistoryModel)

    @Query("SELECT * FROM food")
    fun getFoods(): LiveData<List<HistoryModel>>

    @Query("SELECT * FROM foods")
    fun getAllFoods(): LiveData<List<Food>>

    @Query("DELETE FROM food")
    suspend fun deleteAll()
}