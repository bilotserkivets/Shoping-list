package com.example.shopinglist

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopinglist.database.room.AppRoomDatabase
import com.example.shopinglist.database.room.repository.RoomRepository
import com.example.shopinglist.model.Product
import com.example.shopinglist.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val context = application

    init {
        initDatabase {
            Log.d("InitDatabase", "init database true")
        }
    }

    fun initDatabase(onSuccess: () -> Unit) {
        val dao = AppRoomDatabase.getInstance(context).getRoomDao()
        REPOSITORY = RoomRepository(dao)
        onSuccess()
    }

    fun allProduct() = REPOSITORY.allProduct

    fun addProduct(product: Product, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.create(product = product) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun deleteProduct(product: Product, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.delete(product = product) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteTable()
        }
    }
}