package com.example.peerbuddy.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Question::class, History::class], version = 1)
abstract class QuizRoomDatabase: RoomDatabase() {
    abstract fun questionDao(): QuestionDao

    companion object {
        @Volatile
        private var INSTANCE: QuizRoomDatabase? = null
        @JvmStatic
        fun getDatabase(context: Context): QuizRoomDatabase {
            if (INSTANCE == null) {
                synchronized(QuizRoomDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        QuizRoomDatabase::class.java, "quiz_database")
                        .build()
                }
            }
            return INSTANCE as QuizRoomDatabase
        }
    }
}