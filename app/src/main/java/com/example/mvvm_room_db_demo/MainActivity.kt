package com.example.mvvm_room_db_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_room_db_demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)

        val notesdao=NotesDatabase.getDatabase(applicationContext).notesDao()
        val notesReprository=NotesReprository(notesdao)
        val mainViewModelHandler=ViewModelProvider(this,MainVIewModelFactory(notesReprository)).get(MainViewModelHandler::class.java)

        mainViewModelHandler.getNotes().observe(this,{
            binding.textView3.text=it.toString()
        }

        )

        binding.button2.setOnClickListener {
            if (binding.edittext.editText!!.text.isEmpty())
            {
                binding.edittext.editText!!.error= "eror".toString()
                Log.e("DATA ADD", "onCreate: "+binding.edittext.editText!!.text )

            }
            else{
                mainViewModelHandler.insertNotesRep(Notes(0, binding.edittext.editText!!.text.toString()))
                Toast.makeText(applicationContext, "inserted", Toast.LENGTH_SHORT).show()
            }
            
        }


    }
}