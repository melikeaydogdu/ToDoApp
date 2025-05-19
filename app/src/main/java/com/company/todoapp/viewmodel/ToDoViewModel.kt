package com.company.todoapp.viewmodel

import androidx.lifecycle.*
import com.company.todoapp.data.ToDo
import com.company.todoapp.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(
    private val repository: ToDoRepository
) : ViewModel() {

    val allToDos = repository.getAllToDos()

    fun searchToDos(query: String) = repository.searchToDos(query)

    fun insertToDo(todo: ToDo) = viewModelScope.launch {
        repository.insertToDo(todo)
    }

    fun updateToDo(todo: ToDo) = viewModelScope.launch {
        repository.updateToDo(todo)
    }

    fun deleteToDo(todo: ToDo) = viewModelScope.launch {
        repository.deleteToDo(todo)
    }
}
