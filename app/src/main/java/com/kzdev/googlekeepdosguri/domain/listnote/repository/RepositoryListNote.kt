package com.kzdev.googlekeepdosguri.domain.listnote.repository

import com.kzdev.googlekeepdosguri.domain.listnote.service.ListNoteService

class RepositoryListNote(private val listNoteService: ListNoteService) {

    fun getAllNotes() = listNoteService.getAllNotes()
}