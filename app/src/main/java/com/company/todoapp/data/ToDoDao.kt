package com.company.todoapp.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ToDoDao {

    @Query("SELECT * FROM todos ORDER BY id DESC")
    fun getAllToDos(): LiveData<List<ToDo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToDo(todo: ToDo)

    @Update
    suspend fun updateToDo(todo: ToDo)

    @Delete
    suspend fun deleteToDo(todo: ToDo)

    @Query("SELECT * FROM todos WHERE task LIKE '%' || :searchQuery || '%'")
    fun searchToDos(searchQuery: String): LiveData<List<ToDo>>
}
