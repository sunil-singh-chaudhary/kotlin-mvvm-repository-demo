package com.example.mvvm_room_db_demo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModelHandler(private val reprository: NotesReprository) : ViewModel() {

    fun getNotes(): LiveData<List<Notes>>{

        return reprository.getNotesList()
    }
    fun  insertNotesRep(notes: Notes){

        viewModelScope.launch(Dispatchers.IO) {
            reprository.insertNotes(notes)
        }


    }
}