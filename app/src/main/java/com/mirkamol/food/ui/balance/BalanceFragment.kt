package com.mirkamol.food.ui.balance

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mirkamol.food.R
import com.mirkamol.food.data.local.entity.Food
import com.mirkamol.food.data.local.entity.HistoryModel
import com.mirkamol.food.databinding.FragmentBalanceBinding
import com.mirkamol.food.databinding.FragmentFoodsBinding
import com.mirkamol.food.ui.BaseFragment
import com.mirkamol.food.ui.addfood.AddViewModel
import com.mirkamol.food.ui.history.HistoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BalanceFragment : BaseFragment(R.layout.fragment_balance) {
    private val binding by viewBinding(FragmentBalanceBinding::bind)
    private val viewModel: BalanceViewModel by viewModels()
    var foodName: String? = null
    var quantity: String? = null
    var price: String? = null
    var kafeName: String? = null
    var countPerson: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            if (it != null) {
                kafeName = it.get("kafeName").toString()
                countPerson = it.get("countPerson").toString()
                foodName = it.get("foodName").toString()
                quantity = it.get("quantity").toString()
                price = it.get("price").toString()

            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addFoodDatabase()
        initViews()
        onBackClick()
    }

    private fun initViews() {
        binding.apply {
            tvSum.text = "Xisob:  ${countPerson!!.toLong() * price!!.toLong()}"
            tvKfName.text = "kafeName:  " + kafeName
            tvCount.text = "countPerson:  " + countPerson
            tvName.text = "foodName:  " + foodName
            tvQuantity.text = "quantity:  " + quantity
            tvPrice.text = "price:  " + price
        }
    }

    private fun addFoodDatabase() {
        if (kafeName != null &&
            countPerson != null
            && foodName != null
            && quantity != null
            && price != null) {
            viewModel.addFood(
                HistoryModel(
                    name = kafeName!!,
                    count = countPerson!!,
                    foodName = foodName!!,
                    quantity = quantity!!,
                    price = price!!,
                )
            )
        }

    }

    private fun onBackClick() {
        binding.back.setOnClickListener {
            onBackPressed()
        }
    }

}