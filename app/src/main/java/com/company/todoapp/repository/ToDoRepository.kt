package com.company.todoapp.repository

import com.company.todoapp.data.ToDo
import com.company.todoapp.data.ToDoDao
import javax.inject.Inject

class ToDoRepository @Inject constructor(private val toDoDao: ToDoDao) {

    fun getAllToDos() = toDoDao.getAllToDos()

    fun searchToDos(query: String) = toDoDao.searchToDos(query)

    suspend fun insertToDo(todo: ToDo) = toDoDao.insertToDo(todo)

    suspend fun updateToDo(todo: ToDo) = toDoDao.updateToDo(todo)

    suspend fun deleteToDo(todo: ToDo) = toDoDao.deleteToDo(todo)
}
