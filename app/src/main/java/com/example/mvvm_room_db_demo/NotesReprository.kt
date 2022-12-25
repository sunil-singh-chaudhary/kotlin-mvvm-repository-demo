package com.example.mvvm_room_db_demo

import androidx.lifecycle.LiveData

class NotesReprository(private val notesDAO: NotesDAO) {

    suspend fun insertNotes(notes: Notes){
        notesDAO.insert(notes)
    }

    fun getNotesList() : LiveData<List<Notes>>{

        return notesDAO.getALLNotes()
    }


}