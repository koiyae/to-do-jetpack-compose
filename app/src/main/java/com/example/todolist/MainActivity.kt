package com.example.todolist

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.todolist.theme.AppTheme
import com.example.todolist.ui.screens.mainscreen.ToDoList
import com.example.todolist.ui.screens.signinscreen.SignInScreen
import com.example.todolist.ui.screens.signupscreen.SignUpScreen
import com.example.todolist.ui.viewmodels.ToDoListViewModel

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel by viewModels<ToDoListViewModel>()
                    val tasksList by viewModel.uiState.collectAsState()
//                    ToDoList(
//                        viewModel,
//                        tasksList,
//                        modifier = Modifier
//                            .consumeWindowInsets(innerPadding)
//                            .padding(innerPadding)
//                            .imePadding()
//                    )
//                    SignInScreen()
                    SignUpScreen()
                }
            }
        }
    }
}
