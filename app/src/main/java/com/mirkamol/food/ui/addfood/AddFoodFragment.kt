package com.mirkamol.food.ui.addfood

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mirkamol.food.R
import com.mirkamol.food.data.local.entity.Food
import com.mirkamol.food.databinding.FragmentAddFoodBinding
import com.mirkamol.food.ui.BaseFragment
import com.mirkamol.food.utils.dialog.MenuDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFoodFragment : BaseFragment(R.layout.fragment_add_food) {
    private val binding by viewBinding(FragmentAddFoodBinding::bind)
    private val viewModel: AddViewModel by viewModels()
    var kafeName = ""
    var countPerson = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            if (it != null) {
                kafeName = it.get("kafeName").toString()
                countPerson = it.get("countPerson").toString()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(this) {
          findNavController().navigate(R.id.createFragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        onBackClick()

    }

    private fun onBackClick() {
        binding.back.setOnClickListener {
            findNavController().navigate(R.id.createFragment)
        }
    }

    private fun initViews() {
        binding.btnAdd.setOnClickListener {
            val foodName = binding.edtName.text.toString().trim()
            val quantity = binding.edtQuantity.text.toString().trim()
            val price = binding.edtPrice.text.toString().trim()

            if (kafeName.isNotEmpty() && countPerson.isNotEmpty() && foodName.isNotEmpty() && quantity.isNotEmpty() && price.isNotEmpty()) {
                viewModel.addFood(
                    Food(
                        foodName = foodName,
                        price = price,
                        quantity = quantity,
                        kafeName = kafeName,
                        countPerson = countPerson
                    )
                )
                Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show()
                findNavController().navigate(
                    R.id.action_addFoodFragment_to_createFragment2,
                    bundleOf(
                        "kafeName" to kafeName,
                        "countPerson" to countPerson,
                        "foodName" to foodName,
                        "price" to price,
                        "quantity" to quantity
                    )
                )
            } else {
                Toast.makeText(context, "Enter datas!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
