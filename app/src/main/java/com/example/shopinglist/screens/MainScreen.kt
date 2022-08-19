package com.example.shopinglist.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen() {
    Scaffold() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
                )
            {
                Text(
                    text = "Bananas",
                    fontSize = 24.sp,
                    color = Color.Black
                    )
                Text(
                    text = "20",
                    fontSize = 24.sp,
                    color = Color.Black
                    )
            }
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Row(modifier = Modifier.fillMaxWidth(0.8f)) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "Delete",
                        modifier = Modifier.size(32.dp),
                        tint = MaterialTheme.colors.primary
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                    ) {
                    Icon(
                        imageVector = Icons.Filled.AddCircle,
                        contentDescription = "Plus",
                        modifier = Modifier.size(32.dp),
                        tint = MaterialTheme.colors.primary
                    )
                    Icon(
                        imageVector = Icons.Filled.Refresh,
                        contentDescription = "Plus",
                        modifier = Modifier.size(32.dp),
                        tint = MaterialTheme.colors.primary
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPrev() {
    MainScreen()
}