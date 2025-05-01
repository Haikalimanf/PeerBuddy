package com.example.peerbuddy.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface QuestionDao {
    // Mengambil pertanyaan berdasarkan ID
    @Query("SELECT * FROM question WHERE question_id = :question_Id")
    fun getQuestionById(question_Id: Int): LiveData<List<Question>>

    @Query("SELECT * FROM History")
    fun getAllHistory(): LiveData<List<History>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHistory(history: History)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(questions: List<Question>)

    @Query("SELECT COUNT(*) FROM question")
    fun getQuestionCount(): LiveData<Int>
}