package com.example.peerbuddy.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.peerbuddy.data.local.History

class HistoryDiffCallback(private val oldNoteList: List<History>, private val newNoteList: List<History>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldNoteList.size
    override fun getNewListSize(): Int = newNoteList.size
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldNoteList[oldItemPosition].history_id == newNoteList[newItemPosition].history_id
    }
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}