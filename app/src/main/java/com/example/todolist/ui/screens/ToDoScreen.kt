package com.example.todolist.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.example.todolist.data.Tasks
import com.example.todolist.data.TasksList
import com.example.todolist.ui.components.ButtonsToDoList
import com.example.todolist.ui.components.TextFields
import com.example.todolist.ui.components.ToDoListItem
import com.example.todolist.ui.viewmodels.ToDoListViewModel


@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun ToDoList(
    viewModel: ToDoListViewModel,
    tasksList: TasksList,
    modifier: Modifier = Modifier
) {
    val title = remember { mutableStateOf("") }
    val task = remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
            .statusBarsPadding()
            .clip(MaterialTheme.shapes.large)
            .padding(bottom = 10.dp)
            .padding(horizontal = 20.dp)
            .pointerInput(Unit) {
                detectTapGestures {
                    focusManager.clearFocus()
                }
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        val addItem = { addItem(viewModel, title, task, focusManager) }
        val removeItem = { viewModel.removeTask() }
        Column(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "To-Do",
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )

            TextFields(title, task)
            ButtonsToDoList(addItem, removeItem)
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .padding(10.dp)
                .clip(MaterialTheme.shapes.large)
        ) {
            items(tasksList.list) { task ->
                ToDoListItem(task)
            }
        }
    }
}


private fun addItem(
    viewModel: ToDoListViewModel,
    title: MutableState<String>,
    task: MutableState<String>,
    focusManager: FocusManager
) {
    if (title.value.isNotBlank() && task.value.isNotBlank()) {
        val newTask = Tasks(title.value, task.value)
        viewModel.addTask(newTask)

        title.value = ""
        task.value = ""

        focusManager.clearFocus()
    }
}