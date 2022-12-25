package com.example.mvvm_room_db_demo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NotesDAO {

     @Insert
    suspend  fun insert(notes:Notes)

     @Delete
     suspend fun deleteData(notes: Notes)

     @Query("SELECT * FROM notes")
     fun getALLNotes() : LiveData<List<Notes>>


}