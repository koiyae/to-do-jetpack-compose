package com.example.todolist.ui.screens.mainscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.todolist.data.Tasks
import com.example.todolist.ui.viewmodels.ToDoListViewModel

@Composable
fun ToDoListItem(
    viewModel: ToDoListViewModel, task: Tasks, modifier: Modifier = Modifier
) {
    var isEditing by remember { mutableStateOf(false) }
    var editedText by remember { mutableStateOf(task.task) }

    if (isEditing) {
        Column(
            modifier = Modifier
                .clip(MaterialTheme.shapes.extraLarge)
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                        .weight(2f),
                    text = task.title,
                    style = MaterialTheme.typography.headlineSmall
                )
                Button(
                    modifier = Modifier.size(45.dp),
                    onClick = {
                        viewModel.updateTask(task, editedText)
                        isEditing = false
                    },
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onPrimaryContainer),
                    shape = RoundedCornerShape(50.dp),
                    contentPadding = PaddingValues()
                ) {
                    Icon(
                        imageVector = Icons.Default.Check, contentDescription = "confirm"
                    )
                }
            }
            TextField(
                value = editedText,
                onValueChange = { editedText = it },
                modifier = Modifier
                    .padding(start = 20.dp, bottom = 20.dp)
                    .fillMaxWidth(),
                singleLine = false,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                    cursorColor = MaterialTheme.colorScheme.primary,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }

    } else {
        Column(
            modifier = Modifier
                .clip(MaterialTheme.shapes.extraLarge)
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,

            ) {
            Row {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                        .weight(2f),
                    text = task.title,
                    style = MaterialTheme.typography.headlineSmall
                )
                Button(
                    modifier = Modifier.size(45.dp),
                    onClick = {
                        isEditing = !isEditing
                    },
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onPrimaryContainer),
                    contentPadding = PaddingValues(10.dp)
                ) {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        imageVector = Icons.Filled.Edit,
                        contentDescription = "edit"
                    )
                }
            }

            Text(
                modifier = Modifier.padding(start = 20.dp, bottom = 20.dp),
                text = task.task,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}