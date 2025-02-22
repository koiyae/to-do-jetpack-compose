package com.example.todolist.ui.screens.signinscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todolist.theme.AppTheme

@Composable
fun SignInScreen() {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = 20.dp)
            .statusBarsPadding()
            .pointerInput(Unit) {
                detectTapGestures {
                    focusManager.clearFocus()
                }
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        var login by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Text(
            text = "Login",
            style = MaterialTheme.typography.displayLarge,
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = login,
            onValueChange = { login = it },
            label = { Text("Usuário") },
            textStyle = MaterialTheme.typography.bodyLarge,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                cursorColor = MaterialTheme.colorScheme.primary,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = MaterialTheme.shapes.extraLarge,
        )
        TextField(modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") },
            textStyle = MaterialTheme.typography.bodyLarge,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                cursorColor = MaterialTheme.colorScheme.primary,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = MaterialTheme.shapes.extraLarge,
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                onClick = {},
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondaryContainer)
            ) {
                Text(
                    text = "Cadastrar",
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                )
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                onClick = {},
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.inversePrimary)
            ) {
                Text(text = "Entrar",
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    ))
            }
        }

    }
}

@Preview
@Composable
fun SignInScreenPreview() {
    AppTheme {
        SignInScreen()
    }
}