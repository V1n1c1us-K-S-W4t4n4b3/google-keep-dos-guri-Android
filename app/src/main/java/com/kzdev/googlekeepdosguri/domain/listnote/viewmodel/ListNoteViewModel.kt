package com.kzdev.googlekeepdosguri.domain.listnote.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.kzdev.googlekeepdosguri.common.network.RetrofitUtils
import com.kzdev.googlekeepdosguri.domain.listnote.model.NoteListModel
import com.kzdev.googlekeepdosguri.domain.listnote.repository.RepositoryListNote
import com.kzdev.googlekeepdosguri.domain.listnote.service.ListNoteService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListNoteViewModel(private val repository: RepositoryListNote) : ViewModel() {

    val noteList = MutableLiveData<NoteListModel>()
    val error = MutableLiveData<Boolean>()

    fun getAllNote() {
        val request = repository.getAllNotes()
        request.enqueue(object : Callback<NoteListModel> {
            override fun onResponse(
                call: Call<NoteListModel>,
                response: Response<NoteListModel>,
            ) {
                noteList.postValue(response.body())
            }

            override fun onFailure(call: Call<NoteListModel>, t: Throwable) {
                error.postValue(true)
            }

        })
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val service = RetrofitUtils.retrofit.create(ListNoteService::class.java)
                val repository = RepositoryListNote(service)
                ListNoteViewModel(repository)
            }
        }
    }
}