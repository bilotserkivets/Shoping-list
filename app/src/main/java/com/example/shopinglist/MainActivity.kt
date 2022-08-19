package com.example.shopinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.shopinglist.screens.MainScreen
import com.example.shopinglist.ui.theme.ShopingListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
                MainScreen()
            }
        }
    }
}