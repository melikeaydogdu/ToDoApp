package com.company.todoapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.company.todoapp.data.ToDo
import com.company.todoapp.databinding.ActivityAddToDoBinding
import com.company.todoapp.viewmodel.ToDoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddToDoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddToDoBinding
    private val viewModel: ToDoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddToDoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener {
            val taskText = binding.editTextTask.text.toString().trim()
            if (taskText.isNotEmpty()) {
                val newToDo = ToDo(task = taskText)
                viewModel.insertToDo(newToDo)
                Toast.makeText(this, "Görev eklendi!", Toast.LENGTH_SHORT).show()
                finish() // geri dön
            } else {
                Toast.makeText(this, "Lütfen görev gir", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
