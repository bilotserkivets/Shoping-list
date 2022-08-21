package com.example.shopinglist.database.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shopinglist.model.Product

@Dao
interface ProductRoomDao {

    @Query("SELECT * FROM products_table")
    fun getAll() : LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(product: Product)

    @Update
    suspend fun updateProduct(product: Product)

    @Delete
    suspend fun deleteProduct(product: Product)

    @Query("DELETE FROM products_table")
    suspend fun deleteAll()
}