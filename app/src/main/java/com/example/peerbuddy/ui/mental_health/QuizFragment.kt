package com.example.peerbuddy.ui.mental_health

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.peerbuddy.R
import com.example.peerbuddy.data.local.History
import com.example.peerbuddy.utils.DateHelper
import com.example.peerbuddy.databinding.FragmentQuizBinding


class QuizFragment : Fragment() {
    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MentalHealthViewModel
    private var questionId = 1
    private var totalQuestions = 1
    private var skorSementara = 0
    private var pilihanSkor = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MentalHealthViewModel::class.java)

        viewModel.getQuestionCount().observe(viewLifecycleOwner) { count ->
            totalQuestions = count ?: 0
        }

        fun resetButtonBackground() {
            binding.btnSangatSering.background = ContextCompat.getDrawable(requireContext(), R.drawable.rounded_button_stroke_green)
            binding.btnCukupSering.background = ContextCompat.getDrawable(requireContext(), R.drawable.rounded_button_stroke_green)
            binding.btnKadangKadang.background = ContextCompat.getDrawable(requireContext(), R.drawable.rounded_button_stroke_green)
            binding.btnTidakPernah.background = ContextCompat.getDrawable(requireContext(), R.drawable.rounded_button_stroke_green)
        }

        fun loadQuestion(id: Int) {
            viewModel.getQuestionById(id).observe(viewLifecycleOwner) { list ->
                binding.questionText.text = list.firstOrNull()?.question ?: "Pertanyaan tidak tersedia"
                pilihanSkor = 0
                resetButtonBackground()
            }
        }

        loadQuestion(questionId)

        fun selectButton(button: Button) {
            resetButtonBackground()
            button.background = ContextCompat.getDrawable(requireContext(), R.drawable.rounded_button_stroke_green_selected)
        }

        fun processAnswer(score: Int, button: Button) {
            pilihanSkor = score
            skorSementara += pilihanSkor
            selectButton(button)
        }

        binding.btnSangatSering.setOnClickListener {
            processAnswer(4, binding.btnSangatSering)
        }

        binding.btnCukupSering.setOnClickListener {
            processAnswer(3, binding.btnCukupSering)
        }

        binding.btnKadangKadang.setOnClickListener {
            processAnswer(2, binding.btnKadangKadang)
        }

        binding.btnTidakPernah.setOnClickListener {
            processAnswer(1, binding.btnTidakPernah)
        }

        binding.btnSubmit.setOnClickListener {
            if (pilihanSkor == 0) {
                Toast.makeText(requireContext(), "Silakan pilih jawaban terlebih dahulu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            skorSementara += pilihanSkor

            if (questionId < totalQuestions) {
                questionId++
                loadQuestion(questionId)
                pilihanSkor = 0
                binding.btnSubmit.text = if (questionId == totalQuestions) "Submit" else "Next"
            } else {
                val newHistory = History(
                    skor = skorSementara,
                    question_id = 0,
                    date = DateHelper.getCurrentDate()
                )
                viewModel.insert(newHistory)
                showCompletionDialog()
            }
        }

    }

    private fun showCompletionDialog() {
        val dialogBuilder = AlertDialog.Builder(requireContext())
        dialogBuilder.setMessage("Selamat, Anda telah menyelesaikan kuis. Hasil dapat dilihat di Riwayat.")
            .setCancelable(false)
            .setPositiveButton("OK") { dialog, id ->
                requireActivity().onBackPressed()
            }

        val alert = dialogBuilder.create()
        alert.setTitle("Kuis Selesai")
        alert.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



