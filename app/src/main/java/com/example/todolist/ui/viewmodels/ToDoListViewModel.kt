package com.example.todolist.ui.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.example.todolist.data.Tasks
import com.example.todolist.data.TasksList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ToDoListViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TasksList(listOf()))
    val uiState: StateFlow<TasksList> = _uiState.asStateFlow()

    fun addTask(task: Tasks) {
        val updatedList = _uiState.value.list.toMutableList().apply {
            add(task)
        }
        _uiState.value = TasksList(updatedList)
    }

    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    fun removeTask() {
        val updatedList = _uiState.value.list.toMutableList().apply {
            if(isNotEmpty()){
                removeLast()
            }
        }
        _uiState.value = TasksList(updatedList)
    }

    fun updateTask(taskToUpdate: Tasks, newTaskValue: String) {
        val updatedList = _uiState.value.list.map { task ->
            if (task == taskToUpdate) {
                task.copy(
                    task = newTaskValue
                )
            } else {
                task
            }
        }
        _uiState.value = TasksList(updatedList)
    }
}