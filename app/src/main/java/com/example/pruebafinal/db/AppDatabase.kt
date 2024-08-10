package com.example.pruebafinal.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pruebafinal.entity.RecipeDao
import com.example.pruebafinal.entity.RecipeEntity


@Database(entities = [RecipeEntity::class], version = 4)
abstract class AppDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "recipe_database"
                )
                    .fallbackToDestructiveMigration() // Esta línea permite la destrucción de la base de datos en caso de migración
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}