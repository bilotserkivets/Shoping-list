package com.example.shopinglist.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shopinglist.database.room.dao.ProductRoomDao
import com.example.shopinglist.model.Product

@Database(entities = [Product::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase(){

    abstract fun getRoomDao(): ProductRoomDao

    companion object {
        @Volatile
        private var INSTANCE: AppRoomDatabase? = null

        fun getInstance(context: Context) : AppRoomDatabase {
            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppRoomDatabase::class.java,
                    "shopping_database"
                ).build()
                return INSTANCE as AppRoomDatabase
            }
            return INSTANCE as AppRoomDatabase
        }
    }
}