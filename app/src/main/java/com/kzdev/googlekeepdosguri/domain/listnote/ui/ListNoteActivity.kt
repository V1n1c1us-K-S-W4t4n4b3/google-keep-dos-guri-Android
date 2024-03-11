package com.kzdev.googlekeepdosguri.domain.listnote.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kzdev.googlekeepdosguri.databinding.ActivityListNoteBinding
import com.kzdev.googlekeepdosguri.domain.listnote.adapter.NoteAdapter
import com.kzdev.googlekeepdosguri.domain.listnote.model.NoteModel
import com.kzdev.googlekeepdosguri.domain.listnote.viewmodel.ListNoteViewModel

class ListNoteActivity : AppCompatActivity() {

    private val binding by lazy { ActivityListNoteBinding.inflate(layoutInflater) }

    private val viewModel: ListNoteViewModel by viewModels { ListNoteViewModel.Factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        setupObservers()
        viewModel.getAllNote()
    }

    private fun setupObservers() {
        viewModel.noteList.observe(this) {
            setupRecyclerView(it.payload)
        }
        viewModel.error.observe(this) {
            Toast.makeText(this, "Ocorreu um erro", Toast.LENGTH_LONG).show()
        }
    }

    private fun setupRecyclerView(list: List<NoteModel>) {
        val noteAdapter = NoteAdapter(list)

        binding.rvNoteList.apply {
            layoutManager = LinearLayoutManager(this@ListNoteActivity)
            adapter = noteAdapter
        }
    }
}