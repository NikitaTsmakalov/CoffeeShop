package com.example.coffeeshop.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coffeeshop.Domain.BannerModel
import com.example.coffeeshop.Domain.CategoryModel
import com.example.coffeeshop.Domain.ItemsModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainRepository {
    private val firebaseDatabase = FirebaseDatabase.getInstance("https://coffeeshop25-2e0b8-default-rtdb.europe-west1.firebasedatabase.app")

    fun loadBanner(): LiveData<MutableList<BannerModel>> {
        val listData = MutableLiveData<MutableList<BannerModel>>()
        val ref = firebaseDatabase.getReference("Banner")
        println("Starting Firebase listener for Banner") // Отладка начала
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<BannerModel>()
                println("Snapshot exists: ${snapshot.exists()}") // Проверяем, есть ли данные
                for (childSnapshot in snapshot.children) {
                    val item = childSnapshot.getValue(BannerModel::class.java)
                    println("Child snapshot: $childSnapshot, parsed item: $item") // Подробности о каждом элементе
                    item?.let { list.add(it) }
                }
                println("Firebase Banner Data: $list") // Итоговый список
                listData.value = list
            }

            override fun onCancelled(error: DatabaseError) {
                println("Firebase Error: ${error.message}") // Ошибка подключения
            }
        })
        return listData
    }


    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        val listData = MutableLiveData<MutableList<CategoryModel>>()
        val ref = firebaseDatabase.getReference("Category")
        println("Starting Firebase listener for Banner") // Отладка начала
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<CategoryModel>()
                println("Snapshot exists: ${snapshot.exists()}") // Проверяем, есть ли данные
                for (childSnapshot in snapshot.children) {
                    val item = childSnapshot.getValue(CategoryModel::class.java)
                    println("Child snapshot: $childSnapshot, parsed item: $item") // Подробности о каждом элементе
                    item?.let { list.add(it) }
                }
                println("Firebase Banner Data: $list") // Итоговый список
                listData.value = list
            }

            override fun onCancelled(error: DatabaseError) {
                println("Firebase Error: ${error.message}") // Ошибка подключения
            }
        })
        return listData
    }

    fun loadPopular(): LiveData<MutableList<ItemsModel>> {
        val listData = MutableLiveData<MutableList<ItemsModel>>()
        val ref = firebaseDatabase.getReference("Popular")
        println("Starting Firebase listener for Banner") // Отладка начала
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<ItemsModel>()
                println("Snapshot exists: ${snapshot.exists()}") // Проверяем, есть ли данные
                for (childSnapshot in snapshot.children) {
                    val item = childSnapshot.getValue(ItemsModel::class.java)
                    println("Child snapshot: $childSnapshot, parsed item: $item") // Подробности о каждом элементе
                    item?.let { list.add(it) }
                }
                println("Firebase Category Data: $list") // Итоговый список
                listData.value = list
            }

            override fun onCancelled(error: DatabaseError) {
                println("Firebase Error: ${error.message}") // Ошибка подключения
            }
        })
        return listData
    }
}