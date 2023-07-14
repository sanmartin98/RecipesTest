package com.example.recipestest.ui.screen.main

import com.example.domain.model.Recipe

sealed class RecipeScreenState {
    object OnLoading : RecipeScreenState()
    data class OnRecipesLoaded(val recipes: List<Recipe>) : RecipeScreenState()
    data class OnError(val errorMessage: String) : RecipeScreenState()
}
