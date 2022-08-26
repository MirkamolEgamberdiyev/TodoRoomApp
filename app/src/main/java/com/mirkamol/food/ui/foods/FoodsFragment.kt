package com.mirkamol.food.ui.foods

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mirkamol.food.R
import com.mirkamol.food.data.local.entity.PassFood
import com.mirkamol.food.databinding.FragmentFoodsBinding
import com.mirkamol.food.ui.BaseFragment
import com.mirkamol.food.ui.addfood.AddViewModel
import com.mirkamol.food.ui.foods.adapter.FoodsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodsFragment : BaseFragment(R.layout.fragment_foods) {
    private val binding by viewBinding(FragmentFoodsBinding::bind)
    private lateinit var adapter: FoodsAdapter
    private val foodsViewModel: FoodsViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        loadRecourse()
        binding.back.setOnClickListener {
            onBackPressed()
        }
    }
    private fun loadRecourse() {
        foodsViewModel.getCreateFood().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
    private fun setupAdapter() {
        adapter = FoodsAdapter {
            setBackStackData("key", PassFood(it.foodName, it.price, it.quantity))
            findNavController().popBackStack()
        }
        binding.recyclerView.adapter = adapter
    }
}