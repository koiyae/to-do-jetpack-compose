package com.example.todolist.ui.screens.mainscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.todolist.data.Tasks

@Composable
fun ToDoListItem(task: Tasks) {
    Column (
        modifier = Modifier
            .clip(MaterialTheme.shapes.large)
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
            text = task.title,
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            modifier = Modifier.padding(start = 20.dp, bottom = 10.dp),
            text = task.task,
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}