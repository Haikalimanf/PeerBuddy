package com.example.peerbuddy.data.local

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

interface QuestionDao {
    // Mengambil pertanyaan berdasarkan ID
    @Query("SELECT * FROM question WHERE question_id = :question_Id")
    suspend fun getQuestionById(question_Id: Int): Question

    // Mengupdate skor di tabel History berdasarkan history_id
    @Query("UPDATE history SET skor = :newScore WHERE history_id = :historyId")
    suspend fun updateScore(newScore: Int, historyId: Int)
}