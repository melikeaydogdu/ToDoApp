package com.company.todoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.company.todoapp.adapter.ToDoAdapter
import com.company.todoapp.databinding.ActivityMainBinding
import com.company.todoapp.viewmodel.ToDoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ToDoAdapter
    private val viewModel: ToDoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ToDoAdapter(emptyList()) { selectedToDo ->
            viewModel.deleteToDo(selectedToDo)
            Toast.makeText(this, "Silindi: ${selectedToDo.task}", Toast.LENGTH_SHORT).show()
        }

        binding.toDoRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.toDoRecyclerView.adapter = adapter

        viewModel.allToDos.observe(this) {
            adapter.updateList(it)
        }

        binding.fabAdd.setOnClickListener {
            startActivity(Intent(this, AddToDoActivity::class.java)) // 👈 burası şimdi çalışmalı
        }
    }
}
