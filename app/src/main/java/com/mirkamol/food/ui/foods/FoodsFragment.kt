package com.mirkamol.food.ui.foods

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mirkamol.food.R
import com.mirkamol.food.databinding.FragmentFoodsBinding
import com.mirkamol.food.ui.BaseFragment
import com.mirkamol.food.ui.addfood.AddViewModel
import com.mirkamol.food.ui.foods.adapter.FoodsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodsFragment : BaseFragment(R.layout.fragment_foods) {
    private val binding by viewBinding(FragmentFoodsBinding::bind)
    private val adapter by lazy { FoodsAdapter() }
    private val foodsViewModel: FoodsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        loadRecourse()
        adapterClickManager()
        onBackClick()
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigate(R.id.createFragment)
        }

    }

    private fun onBackClick() {
        binding.back.setOnClickListener {
            findNavController().navigate(R.id.createFragment)
        }
    }

    private fun adapterClickManager() {
        adapter.itemCLick = {
            findNavController().navigate(
                R.id.action_foodsFragment_to_createFragment,
                bundleOf(
                    "foodName" to it.foodName,
                    "quantity" to it.quantity,
                    "price" to it.price,
                    "kafeName" to it.kafeName,
                    "countPerson" to it.countPerson
                )
            )
        }
    }

    private fun loadRecourse() {
        foodsViewModel.getAllFoods().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun setupAdapter() {
        binding.recyclerView.adapter = adapter
    }
}