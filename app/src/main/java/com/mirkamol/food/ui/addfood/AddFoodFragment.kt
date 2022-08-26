package com.mirkamol.food.ui.addfood

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mirkamol.food.R
import com.mirkamol.food.data.local.entity.CreateFood
import com.mirkamol.food.data.local.entity.PassFood
import com.mirkamol.food.databinding.FragmentAddFoodBinding
import com.mirkamol.food.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFoodFragment : BaseFragment(R.layout.fragment_add_food) {
    private val binding by viewBinding(FragmentAddFoodBinding::bind)
    private val viewModel: AddViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        onBackClick()

    }
    private fun onBackClick() {
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }
    private fun initViews() {
        binding.btnAdd.setOnClickListener {
            val foodName = binding.edtName.text.toString().trim()
            val quantity = binding.edtQuantity.text.toString().trim()
            val price = binding.edtPrice.text.toString().trim()

            if (foodName.isNotEmpty() && quantity.isNotEmpty() && price.isNotEmpty()) {
                viewModel.addCreateFood(
                    CreateFood(
                        foodName = foodName,
                        quantity = quantity,
                        price = price
                    )
                )
               setBackStackData("key", PassFood(foodName, quantity, price), true)

            } else {
                Toast.makeText(context, "Enter datas!", Toast.LENGTH_SHORT).show()
            }
        }
    }


}
