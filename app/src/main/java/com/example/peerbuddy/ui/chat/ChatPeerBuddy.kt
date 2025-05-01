package com.example.peerbuddy.ui.chat

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.peerbuddy.ListCounselorAdapter
import com.example.peerbuddy.R
import com.example.peerbuddy.data.local.Counselor
import com.example.peerbuddy.databinding.ActivityMainBinding

class ChatPeerBuddy : AppCompatActivity() {
    private lateinit var rvCounselors: RecyclerView
    private val list = ArrayList<Counselor>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chat_peer_buddy)

        supportActionBar?.apply {
            title = "Peer Counseler"
            setDisplayHomeAsUpEnabled(true)
            setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this@ChatPeerBuddy, R.color.green)))
        }

        // Inisialisasi RecyclerView
        rvCounselors = findViewById(R.id.rv_counselors)
        rvCounselors.setHasFixedSize(true)

        // Tambahkan data dummy
        list.addAll(getListCounselors())
        showRecyclerList()
    }

    private fun getListCounselors(): ArrayList<Counselor> {
        val names = resources.getStringArray(R.array.data_name)
        val professions = resources.getStringArray(R.array.data_profession)
        val phoneNumbers = resources.getStringArray(R.array.data_phone_number)
        val photoNames = resources.obtainTypedArray(R.array.data_photo)

        val listcounselor = ArrayList<Counselor>()

        for (i in names.indices) {
            val counselor = Counselor(
                name = names[i],
                profession = professions[i],
                photo = photoNames.getResourceId(i, -1),
                phoneNumber = phoneNumbers[i]
            )
            listcounselor.add(counselor)
        }

        return listcounselor
    }

    private fun showRecyclerList() {
        rvCounselors.layoutManager = LinearLayoutManager(this)
        val listCounselorAdapter = ListCounselorAdapter(list)
        rvCounselors.adapter = listCounselorAdapter
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