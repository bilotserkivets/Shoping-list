package com.example.shopinglist

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopinglist.screens.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val mViewModel: MainViewModel =
                viewModel(factory = MainViewModelFactory(context.applicationContext as Application))

            Scaffold(
                topBar = {
                    TopAppBar (
                        title = {
                            Text(text = "Shopping list")
                        },
                        contentColor = Color.White,
                        backgroundColor = MaterialTheme.colors.primary
                    )
                }

            ) {
                MainScreen(viewModel = mViewModel)
            }
        }
    }
}