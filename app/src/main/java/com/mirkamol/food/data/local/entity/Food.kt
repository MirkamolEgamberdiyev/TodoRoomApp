package com.mirkamol.food.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foods")
data class Food(
    @PrimaryKey(autoGenerate = true)
    val id:Int? = null,
    val kafeName:String,
    val countPerson:String,
    var foodName: String,
    var price: String,
    var quantity: String,
)