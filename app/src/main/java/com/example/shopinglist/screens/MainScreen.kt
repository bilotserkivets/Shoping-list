package com.example.shopinglist.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.internal.isLiveLiteralsEnabled
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopinglist.MainViewModel
import com.example.shopinglist.model.Product
import com.example.shopinglist.ui.theme.Blue
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(viewModel: MainViewModel) {
    val products = viewModel.allProduct().observeAsState(listOf()).value
    var nameProduct by remember {
        mutableStateOf("")
    }
    var amount by remember {
        mutableStateOf("")
    }

    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetShape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        sheetElevation = 8.dp,
        sheetState = bottomSheetState,
        sheetContent = {
            Surface() {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)) {
                    Text(
                        text = "Add a new shopping item",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Row(modifier = Modifier.fillMaxWidth()) {
                        TextField(
                            value = nameProduct,
                            label = { Text(text = "Name") },
                            onValueChange = {
                                nameProduct = it
                            },
                            isError = nameProduct.isEmpty(),
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        TextField(
                            value = amount,
                            label = { Text(text = "Amount") },
                            onValueChange = {
                                amount = it
                            },
                            isError = amount.isEmpty()
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, bottom = 32.dp),
                        horizontalArrangement = Arrangement.End
                        ) {
                        Button(
                            onClick = {
                                coroutineScope.launch {
                                    bottomSheetState.hide()
                                }
                            },
                            modifier = Modifier.padding(end = 8.dp)
                        ) {
                            Text(text = "CANCEL")
                        }
                        Button(
                            onClick = {
                                viewModel.addProduct(Product(product = nameProduct, amount = amount.toInt())) {
                                    coroutineScope.launch {
                                        bottomSheetState.hide()
                                    }
                                }
                                nameProduct = ""
                                amount = ""
                            }
                        ) {
                            Text(text = "ADD")
                        }

                    }

                }
            }

        }
    ) {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        coroutineScope.launch {
                            bottomSheetState.show()
                        }
                    },
                    backgroundColor = Blue,
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add product",
                        tint = Color.White
                    )
                }
            }
        ) {
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
            ) {
                items(products) { product ->
                    ProductItem(product = product, viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun ProductItem(product: Product, viewModel: MainViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        Text(
            text = product.product.toString(),
            fontSize = 24.sp,
            color = Color.Black
        )
        Text(
            text = product.amount.toString(),
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
                modifier = Modifier
                    .size(32.dp)
                    .clickable {
                        viewModel.deleteProduct(product){

                        }

                    },
                tint = MaterialTheme.colors.primary,
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

@Composable
fun AlertDialog() {

}

//@Preview(showBackground = true)
//@Composable
//fun MainScreenPrev() {
//    MainScreen(mViewModel)
//}