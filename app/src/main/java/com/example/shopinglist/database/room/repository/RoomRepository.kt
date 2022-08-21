package com.example.shopinglist.database.room.repository

import androidx.lifecycle.LiveData
import com.example.shopinglist.database.room.dao.ProductRoomDao
import com.example.shopinglist.model.Product

class RoomRepository(private val productRoomDao: ProductRoomDao) : DatabaseRepository {

    override val allProduct: LiveData<List<Product>>
        get() = productRoomDao.getAll()

    override suspend fun create(product: Product, onSuccess: () -> Unit) {
        productRoomDao.addProduct(product = product)
        onSuccess()
    }

    override suspend fun update(product: Product, onSuccess: () -> Unit) {
        productRoomDao.updateProduct(product = product)
        onSuccess()
    }

    override suspend fun delete(product: Product, onSuccess: () -> Unit) {
        productRoomDao.deleteProduct(product = product)
        onSuccess()
    }

    override suspend fun deleteTable() {
        productRoomDao.deleteAll()
    }
}