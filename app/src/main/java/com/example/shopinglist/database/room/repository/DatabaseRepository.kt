package com.example.shopinglist.database.room.repository

import androidx.lifecycle.LiveData
import com.example.shopinglist.model.Product

interface DatabaseRepository {

    val allProduct: LiveData<List<Product>>

    suspend fun create(product: Product, onSuccess: () -> Unit)

    suspend fun update(product: Product, onSuccess: () -> Unit)

    suspend fun delete(product: Product, onSuccess: () -> Unit)

    suspend fun deleteTable()
}