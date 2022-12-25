package com.example.mvvm_room_db_demo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Notes::class], version = 1)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun notesDao(): NotesDAO

    companion object {
        @Volatile     //volitile instance means update everytime when everyone is trying to open or close db
        private var INSTANCE: NotesDatabase? = null

        fun getDatabase(context:Context) : NotesDatabase{
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        NotesDatabase::class.java,
                        "NotesDB"
                    ).build()
                }
            }
            return INSTANCE!!
        }

    }
}