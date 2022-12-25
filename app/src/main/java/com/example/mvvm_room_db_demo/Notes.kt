package com.example.mvvm_room_db_demo

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "Notes")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
)
