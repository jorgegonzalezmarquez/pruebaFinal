package com.example.pruebafinal.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pruebafinal.entity.RecipeDao

class RecipeRoomViewModelFactory(private val recipeDao: RecipeDao)
    : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipeRoomViewModel::class.java)) {
            return RecipeRoomViewModel(recipeDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}