package com.company.todoapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.company.todoapp.data.ToDo
import com.company.todoapp.databinding.ItemTodoBinding

class ToDoAdapter(private var todoList: List<ToDo>) :
    RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    class ToDoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ToDoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val todo = todoList[position]
        holder.binding.textViewTask.text = todo.task
    }

    override fun getItemCount(): Int = todoList.size

    fun updateList(newList: List<ToDo>) {
        todoList = newList
        notifyDataSetChanged()
    }
}
