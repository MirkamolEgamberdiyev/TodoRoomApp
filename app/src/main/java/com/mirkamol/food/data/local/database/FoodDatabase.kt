package com.mirkamol.food.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mirkamol.food.data.local.dao.FoodDao
import com.mirkamol.food.data.local.entity.Food
import com.mirkamol.food.data.local.entity.HistoryModel

@Database(entities = [HistoryModel::class, Food::class], version = 1, exportSchema = false)
abstract class FoodDatabase : RoomDatabase() {
    abstract fun historyDao(): FoodDao
}