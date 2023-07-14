package com.example.di.thirdparty

import android.content.Context
import androidx.room.Room
import com.example.data.datasource.local.ILocalRecipeDataSource
import com.example.data.datasource.local.LocalRecipeDataSource
import com.example.data.local.RecipeRoomDataBase
import com.example.data.local.dao.RecipeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRecipeDataBase(
        @ApplicationContext context: Context
    ):RecipeRoomDataBase = Room.databaseBuilder(
        context,
        RecipeRoomDataBase::class.java,
        "recipe_database"
    ).build()

    @Singleton
    @Provides
    fun provideRecipeDao(db: RecipeRoomDataBase):RecipeDao =
        db.getRecipeDao()

    @Singleton
    @Provides
    fun provideLocalRecipeDataSource(
        recipeDao: RecipeDao
    ): ILocalRecipeDataSource {
        return LocalRecipeDataSource(recipeDao)
    }
}