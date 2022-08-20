package com.mirkamol.food.ui.create

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mirkamol.food.R
import com.mirkamol.food.data.local.entity.Food
import com.mirkamol.food.databinding.FragmentCreateBinding
import com.mirkamol.food.ui.BaseFragment
import com.mirkamol.food.ui.create.adapter.CreateAdapter
import com.mirkamol.food.utils.SharedData
import com.mirkamol.food.utils.dialog.MenuDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateFragment : BaseFragment(R.layout.fragment_create) {
    private val binding by viewBinding(FragmentCreateBinding::bind)
    private val adapter by lazy { CreateAdapter() }
    var foodName: String? = null
    var quantity: String? = null
    var price: String? = null
    var kafeName: String? = null
    var countPerson: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            foodName = it.get("foodName").toString()
            quantity = it.get("quantity").toString()
            price = it.get("price").toString()
            kafeName = it.get("kafeName").toString()
            countPerson = it.get("countPerson").toString()
        }
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigate(R.id.homeFragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        initViews()
        adapterItem()
    }

    private fun adapterItem() {
        if (SharedData.list.size > 0) {
            binding.tvMenu.text = "Yana qo'shish"
        }
        if (kafeName != null && countPerson != null && foodName != null && price != null && quantity != null) {
            SharedData.list.add(
                Food(
                    kafeName = kafeName!!, countPerson = countPerson!!,
                    foodName = foodName!!, price = price!!, quantity = quantity!!
                )
            )
            adapter.submitList(SharedData.list)
        }
    }
    private fun setupAdapter() {
        binding.recyclerView.adapter = adapter
    }

    private fun initViews() {
        binding.back.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
        binding.tvMenu.setOnClickListener {
            MenuDialogFragment().show(childFragmentManager, "MyCustomFragment")
            findNavController().navigate(
                R.id.action_createFragment_to_menuDialogFragment,
                bundleOf(
                    "kafeName" to binding.edtName.text.toString(),
                    "countPerson" to binding.edtPerson.text.toString()
                )
            )
        }

        binding.btnXisob.setOnClickListener {
            Log.d("TAG", "initViews: $kafeName $foodName")
            if (kafeName != null && countPerson != null && foodName != null && price != null && quantity != null){
                kafeName=null
                findNavController().navigate(
                    R.id.action_createFragment_to_balanceFragment2,
                    bundleOf(
                        "kafeName" to kafeName,
                        "countPerson" to countPerson,
                        "foodName" to foodName,
                        "price" to price,
                        "quantity" to quantity
                    )
                )
            }

            Toast.makeText(context, "xisoblash uchun food kiritilmagan!", Toast.LENGTH_SHORT).show()

        }

    }
}