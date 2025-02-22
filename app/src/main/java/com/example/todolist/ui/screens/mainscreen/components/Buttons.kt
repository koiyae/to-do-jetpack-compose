package com.example.todolist.ui.screens.mainscreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonsToDoList(
    addItem: () -> Unit,
    removeItem: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        Button(
            modifier = Modifier.fillMaxWidth().weight(1f),
            onClick = { removeItem() },
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
            shape = MaterialTheme.shapes.extraLarge
        ) {
            Text(text = "Remover")
        }
        Button(
            modifier = Modifier.fillMaxWidth().weight(1f),
            onClick = { addItem() },
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
            shape = MaterialTheme.shapes.extraLarge
        ) {
            Text(text = "Adicionar")
        }
    }
}