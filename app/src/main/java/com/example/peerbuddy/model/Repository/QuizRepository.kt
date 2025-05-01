package com.example.peerbuddy.model.Repository

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.LiveData
import com.example.peerbuddy.data.local.History
import com.example.peerbuddy.data.local.Question
import com.example.peerbuddy.data.local.QuestionDao
import com.example.peerbuddy.data.local.QuizRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class QuizRepository(application: Application) {
    private val mQuestionDao: QuestionDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = QuizRoomDatabase.getDatabase(application)
        mQuestionDao = db.questionDao()
    }

    fun getQuestionById(id : Int): LiveData<List<Question>> = mQuestionDao.getQuestionById(id)

    fun getAllHistory(): List<History> = mQuestionDao.getAllHistory()

    fun insert(history: History) {
        executorService.execute { mQuestionDao.insertHistory(history) }
    }

    fun getQuestionCount(): LiveData<Int> = mQuestionDao.getQuestionCount()

}