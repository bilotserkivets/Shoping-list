package com.example.shopinglist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products_table")
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,

    @ColumnInfo val product: String,

    @ColumnInfo val amount: Int
)
