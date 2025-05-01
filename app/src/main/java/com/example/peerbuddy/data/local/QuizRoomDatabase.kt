package com.example.peerbuddy.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Question::class, History::class], version = 1)
abstract class QuizRoomDatabase : RoomDatabase() {
    abstract fun questionDao(): QuestionDao

    companion object {
        @Volatile
        private var INSTANCE: QuizRoomDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): QuizRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuizRoomDatabase::class.java,
                    "quiz_database"
                )
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            CoroutineScope(Dispatchers.IO).launch {
                                INSTANCE?.let { database ->
                                    val dao = database.questionDao()
                                    val questions = listOf(
                                        Question(question = "Seberapa sering Anda merasa kesulitan mengendalikan hal-hal penting dalam hidup Anda dalam satu minggu terakhir?"),
                                        Question(question = "Seberapa sering Anda merasa bahwa segala sesuatu berjalan tidak sesuai rencana dalam satu minggu terakhir?"),
                                        Question(question = "Seberapa sering Anda merasa stres atau tertekan dalam satu minggu terakhir?"),
                                        Question(question = "Seberapa sering Anda merasa tidak mampu mengatasi masalah yang muncul dalam hidup Anda?"),
                                        Question(question = "Seberapa sering Anda merasa bahwa Anda tidak bisa mengendalikan hal-hal yang membuat Anda stres?")
                                    )
                                    dao.insertQuestion(questions)
                                }
                            }
                        }
                    })
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
