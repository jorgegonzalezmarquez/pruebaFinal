package com.example.pruebafinal.services

import com.example.pruebafinal.models.RecipeResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(".")
    suspend fun getRecipes(): Response<RecipeResponse>
}