package com.example.pruebafinal.models

import android.app.Application
import com.example.pruebafinal.db.AppDatabase


class RecipeApp: Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}