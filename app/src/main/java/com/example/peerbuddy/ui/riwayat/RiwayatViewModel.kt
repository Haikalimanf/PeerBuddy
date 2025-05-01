package com.example.peerbuddy.ui.riwayat

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.peerbuddy.data.local.History
import com.example.peerbuddy.model.Repository.QuizRepository

class RiwayatViewModel(application: Application) : AndroidViewModel(application) {
    private val mQuizRepository: QuizRepository = QuizRepository(application)

    val isEmpty: LiveData<Boolean> = getAllHistory().map { list ->
        list.isNullOrEmpty()
    }

    fun getAllHistory(): LiveData<List<History>> = mQuizRepository.getAllHistory()
}
