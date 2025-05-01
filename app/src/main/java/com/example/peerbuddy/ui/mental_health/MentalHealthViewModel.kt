package com.example.peerbuddy.ui.mental_health

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.peerbuddy.data.local.History
import com.example.peerbuddy.data.local.Question
import com.example.peerbuddy.model.Repository.QuizRepository

class MentalHealthViewModel(application: Application): AndroidViewModel(application) {
    private val mQuizRepository: QuizRepository = QuizRepository(application)

    fun getQuestionById(id: Int): LiveData<List<Question>> {
        return mQuizRepository.getQuestionById(id)
    }

    fun getAllHistory() = mQuizRepository.getAllHistory()

    fun insert(history: History) {
        mQuizRepository.insert(history)
    }

    fun getQuestionCount(): LiveData<Int> = mQuizRepository.getQuestionCount()
}