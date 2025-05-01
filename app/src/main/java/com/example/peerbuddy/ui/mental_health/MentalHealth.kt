package com.example.peerbuddy.ui.mental_health

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.peerbuddy.R
import com.example.peerbuddy.databinding.ActivityMentalHealthBinding
import com.example.peerbuddy.utils.ViewModelFactory

class MentalHealth : AppCompatActivity() {

    private lateinit var mentalHealthViewModel: MentalHealthViewModel
    private var _activityMentalHealtBinding: ActivityMentalHealthBinding? = null
    private val binding get() = _activityMentalHealtBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityMentalHealtBinding = ActivityMentalHealthBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.startQuizButton?.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(android.R.id.content, QuizFragment())
                .addToBackStack(null)
                .commit()
        }

        supportActionBar?.apply {
            title = "Quiz Mental Health"
            setDisplayHomeAsUpEnabled(true)
            setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this@MentalHealth, R.color.green)))
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _activityMentalHealtBinding = null
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}