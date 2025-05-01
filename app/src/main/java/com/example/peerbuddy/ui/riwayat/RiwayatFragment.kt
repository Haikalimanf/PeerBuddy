package com.example.peerbuddy.ui.riwayat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.peerbuddy.R
import com.example.peerbuddy.databinding.FragmentQuizBinding
import com.example.peerbuddy.databinding.FragmentRiwayatBinding
import com.example.peerbuddy.ui.mental_health.MentalHealthViewModel


class RiwayatFragment : Fragment() {

    private var _binding: FragmentRiwayatBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RiwayatViewModel
    private lateinit var adapter: RiwayatAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(RiwayatViewModel::class.java)

        adapter = RiwayatAdapter()
        binding.rvRiwayat.layoutManager = LinearLayoutManager(requireContext())
        binding.rvRiwayat.adapter = adapter

        viewModel.getAllHistory().observe(viewLifecycleOwner) { dataList ->
            adapter.setListNotes(dataList)
        }

        viewModel.isEmpty.observe(viewLifecycleOwner) {
            isEmpty(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentRiwayatBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun isEmpty(isEmpty: Boolean) {
        if (isEmpty) {
            binding.tvPeringatan.visibility = View.VISIBLE
        } else {
            binding.tvPeringatan.visibility = View.INVISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}