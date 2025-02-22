package com.example.todolist.utils

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todolist.data.TasksList
import com.example.todolist.ui.screens.mainscreen.ToDoList
import com.example.todolist.ui.screens.signinscreen.SignInScreen
import com.example.todolist.ui.screens.signupscreen.SignUpScreen
import com.example.todolist.ui.viewmodels.ToDoListViewModel

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun ToDoNavigation(
    navController: NavHostController,
    viewModel: ToDoListViewModel,
    tasksList: TasksList,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "main/{user}"
    ) {
        composable("main/{user}") { entry ->
            entry.arguments?.getString("user")?.let { user ->
                ToDoList(
                    viewModel = viewModel,
                    tasksList = tasksList,
                    name = user
                )
            } ?: LaunchedEffect(null) {
                navController.navigate("signInScreen")
            }
        }
        composable("signInScreen") {
            SignInScreen(
                onLoginPressed = {
                    it.login.let { login ->
                        if (login.isNotBlank()) {
                            navController.navigate("main/$login")
                        }
                    }
                },
                onSignUpPressed = {navController.navigate("signUpScreen")}
            )
        }
        composable("signUpScreen") {
            SignUpScreen(
                onBackPressed = { navController.navigate("signInScreen") }
            )
        }
    }
}