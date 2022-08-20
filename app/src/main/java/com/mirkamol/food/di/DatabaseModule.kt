package com.mirkamol.food.di
import android.content.Context
import androidx.room.Room
import com.mirkamol.food.data.local.dao.FoodDao
import com.mirkamol.food.data.local.database.FoodDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideHistoryDatabase(@ApplicationContext context: Context): FoodDatabase {
        return Room.databaseBuilder(context, FoodDatabase::class.java, "history.db")
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun provideHistoryDao(appDatabase: FoodDatabase): FoodDao = appDatabase.historyDao()

}