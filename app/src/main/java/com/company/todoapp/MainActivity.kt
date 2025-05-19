package com.company.todoapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
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

        adapter = ToDoAdapter(emptyList())
        binding.toDoRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.toDoRecyclerView.adapter = adapter

        viewModel.allToDos.observe(this) {
            adapter.updateList(it)
        }

        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(query: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.searchToDos(query.toString()).observe(this@MainActivity) {
                    adapter.updateList(it)
                }
            }
        })
    }
}
