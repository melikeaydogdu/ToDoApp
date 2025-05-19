package com.company.todoapp.di

import android.content.Context
import androidx.room.Room
import com.company.todoapp.data.ToDoDao
import com.company.todoapp.data.ToDoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideToDoDatabase(@ApplicationContext context: Context): ToDoDatabase {
        return Room.databaseBuilder(
            context,
            ToDoDatabase::class.java,
            "todo.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideToDoDao(db: ToDoDatabase): ToDoDao {
        return db.toDoDao()
    }
}
