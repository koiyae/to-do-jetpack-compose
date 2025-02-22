package com.example.todolist

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.todolist.theme.AppTheme
import com.example.todolist.ui.viewmodels.ToDoListViewModel
import com.example.todolist.utils.ToDoNavigation

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
                    val navController = rememberNavController()

                    ToDoNavigation(
                        navController = navController,
                        viewModel = viewModel,
                        tasksList = tasksList,
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

