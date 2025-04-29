package com.example.peerbuddy.ui.beranda

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.peerbuddy.R
import com.example.peerbuddy.databinding.FragmentBerandaBinding
import com.example.peerbuddy.model.BannerData
import com.example.peerbuddy.ui.brain_wise.BrainWise
import com.example.peerbuddy.ui.chat.ChatPeerBuddy
import com.example.peerbuddy.ui.mental_health.MentalHealth
import com.example.peerbuddy.ui.profile.ProfileFragment

class BerandaFragment : Fragment() {

    private var _binding: FragmentBerandaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBerandaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bannerAdapter = BannerAdapter(BannerData.banners)
        binding.rvBanner.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvBanner.adapter = bannerAdapter

        binding.chatPeerBuddy.setOnClickListener {
            val intent = Intent(requireContext(), ChatPeerBuddy::class.java)
            startActivity(intent)
        }

        binding.mentalHealth.setOnClickListener {
            val intent = Intent(requireContext(), MentalHealth::class.java)
            startActivity(intent)
        }

        binding.brainWise.setOnClickListener {
            val intent = Intent(requireContext(), BrainWise::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
