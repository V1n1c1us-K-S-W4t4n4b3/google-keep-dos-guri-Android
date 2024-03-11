package com.kzdev.googlekeepdosguri.domain.listnote.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kzdev.googlekeepdosguri.databinding.ItemNoteListBinding
import com.kzdev.googlekeepdosguri.domain.listnote.model.NoteModel


class NoteAdapter(private val dataSet: List<NoteModel>) :
    RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemNoteListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val binding = ItemNoteListBinding.inflate(inflater, viewGroup, false)


        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.binding.tvTitle.text = dataSet[position].title
        viewHolder.binding.tvContent.text = dataSet[position].content
    }

    override fun getItemCount() = dataSet.size

}
