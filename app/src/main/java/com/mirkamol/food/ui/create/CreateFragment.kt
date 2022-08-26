package com.mirkamol.food.ui.create

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mirkamol.food.R
import com.mirkamol.food.data.local.entity.Food
import com.mirkamol.food.data.local.entity.PassFood
import com.mirkamol.food.databinding.FragmentCreateBinding
import com.mirkamol.food.ui.BaseFragment
import com.mirkamol.food.ui.create.adapter.CreateAdapter
import com.mirkamol.food.utils.dialog.MenuDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateFragment : BaseFragment(R.layout.fragment_create) {
    private val binding by viewBinding(FragmentCreateBinding::bind)
    private val adapter by lazy { CreateAdapter() }
    private val createViewModel: CreateViewModel by viewModels()
    var foodName: String? = null
    var quantity: String? = null
    var price: String? = null
    val list = ArrayList<Food>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setUpAdapter()

    }

    private fun setUpAdapter(){
        getBackStackData<PassFood>("key", true) {
            foodName = it.foodName
            quantity = it.quantity
            price = it.price
            list.add(
                Food(
                    foodName = foodName!!, price = price!!, quantity = quantity!!
                )
            )
            createViewModel.foodList.value = list

            createViewModel.foodList.observe(viewLifecycleOwner) {
                adapter.submitList(it)

                if (it.size > 0) {
                    binding.tvMenu.text = "Yana qo'shish"
                }
            }
        }
        binding.recyclerView.adapter = adapter
    }
    private fun initViews() {
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.tvMenu.setOnClickListener {
            val dialog = MenuDialogFragment {
                when (it) {
                    "add_food" -> {
                        findNavController().navigate(
                            R.id.addFoodFragment
                        )
                    }
                    "take_food" -> {
                        findNavController().navigate(R.id.foodsFragment)
                    }
                }
            }
            dialog.show(childFragmentManager, "MyCustomFragment")
        }

        binding.btnXisob.setOnClickListener {
            if (binding.edtName.text.toString().isNotEmpty() && binding.edtPerson.text.toString()
                    .isNotEmpty()
            ) {
                findNavController().navigate(
                    R.id.action_createFragment_to_balanceFragment2,
                    bundleOf(
                        "kafeName" to binding.edtName.text.toString(),
                        "countPerson" to binding.edtPerson.text.toString(),
                        "foodName" to foodName,
                        "price" to price,
                        "quantity" to quantity
                    )
                )
            }
            Toast.makeText(context, "xisoblash uchun food kiritilmagan!", Toast.LENGTH_SHORT).show()
        }
        binding.btnCalculate.setOnClickListener {
            findNavController().navigate(R.id.calculatorFragment3)
        }


    }


}