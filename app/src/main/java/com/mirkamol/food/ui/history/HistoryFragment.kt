package com.mirkamol.food.ui.history

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mirkamol.food.R
import com.mirkamol.food.databinding.FragmentHistoryBinding
import com.mirkamol.food.ui.BaseFragment
import com.mirkamol.food.ui.history.adapter.HistoryAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : BaseFragment(R.layout.fragment_history) {
    private val binding by viewBinding(FragmentHistoryBinding::bind)
    private val viewModel: HistoryViewModel by viewModels()
    private val adapter by lazy { HistoryAdapter() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        loadRecourse()
        onBackClick()
    }

    private fun onBackClick() {
        binding.back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun loadRecourse() {
        viewModel.getAllFood().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }


    private fun setupAdapter() {
        binding.recyclerView.adapter = adapter
    }
}