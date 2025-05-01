package com.example.peerbuddy.ui.riwayat

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.peerbuddy.data.local.History
import com.example.peerbuddy.databinding.ItemHistoryStressBinding
import com.example.peerbuddy.ui.riwayat.RiwayatAdapter.RiwayatViewHolder
import com.example.peerbuddy.utils.HistoryDiffCallback


class RiwayatAdapter: RecyclerView.Adapter<RiwayatViewHolder>() {

    private val listRiwayat = ArrayList<History>()

    inner class RiwayatViewHolder(private val binding: ItemHistoryStressBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(history: History) {
            with(binding) {
                textResultTitle.text = "Hasil Tes ke-${history.history_id}"
                progressBarStress.progress = history.skor
                textDateTime.text = history.date
            }
        }
    }

    fun setListNotes(listRiwayat: List<History>) {
        val diffCallback = HistoryDiffCallback(this.listRiwayat, listRiwayat)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listRiwayat.clear()
        this.listRiwayat.addAll(listRiwayat)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiwayatViewHolder {
        val binding = ItemHistoryStressBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RiwayatViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listRiwayat.size
    }

    override fun onBindViewHolder(holder: RiwayatViewHolder, position: Int) {
        holder.bind(listRiwayat[position])
    }
}