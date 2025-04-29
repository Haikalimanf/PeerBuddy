package com.example.peerbuddy.model.Repository

import android.app.Application
import com.example.peerbuddy.data.local.QuestionDao
import com.example.peerbuddy.data.local.QuizRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class QuizRepository(application: Application) {
    private val mQuestionDao: QuestionDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = QuizRoomDatabase.getDatabase(application)
        mQuestionDao = db.questionDao
    }
}