package com.mirkamol.food.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mirkamol.food.data.local.entity.CreateFood
import com.mirkamol.food.data.local.entity.Food
import com.mirkamol.food.data.local.entity.HistoryModel

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFood(food: HistoryModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCreateFood(food: CreateFood)

    @Query("SELECT * FROM createFoods")
    fun getCreateFood(): LiveData<List<CreateFood>>

    @Query("SELECT * FROM food")
    fun getFoodHistory(): LiveData<List<HistoryModel>>


}