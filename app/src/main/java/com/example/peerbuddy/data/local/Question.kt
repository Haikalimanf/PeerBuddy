package com.example.peerbuddy.data.local

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
class Question(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "question_id")
    var question_id: Int = 0,

    @ColumnInfo(name = "question")
    var question: String? = null
) : Parcelable