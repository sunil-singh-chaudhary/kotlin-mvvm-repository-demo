package com.example.mvvm_room_db_demo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainVIewModelFactory(private val notesReprository: NotesReprository) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return MainViewModelHandler(notesReprository) as T

    }



}