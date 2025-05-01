package com.example.peerbuddy.data.local

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class History(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "history_id")
    var history_id: Int = 0,

    @ColumnInfo(name = "skor")
    var skor: Int = 0,

    @ColumnInfo(name = "question_id")
    var question_id: Int = 0,

    @ColumnInfo(name = "date")
    var date: String? = null
): Parcelable