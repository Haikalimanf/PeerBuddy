package com.example.peerbuddy.data.local

import androidx.room.Embedded
import androidx.room.Relation

data class QuestionWithHistory(
    @Embedded val question: Question,

    @Relation(
        parentColumn = "question_id",
        entityColumn = "question_id"
    )
    val history: List<History>
)