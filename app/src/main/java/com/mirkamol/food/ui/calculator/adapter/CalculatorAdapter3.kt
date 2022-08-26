package com.mirkamol.food.ui.calculator.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.food.databinding.ItemCalculator2Binding

class CalculatorAdapter3(val list: ArrayList<String>, var listener: (String) -> Unit) :
    RecyclerView.Adapter<CalculatorAdapter3.VH>() {

    inner class VH(private val binding: ItemCalculator2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            binding.apply {
                itemRecycler.text = data
                itemRecycler.setOnClickListener {
                    Log.d("TAG", "bind: $data")
                    listener.invoke(data)

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            ItemCalculator2Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(list.get(position))

    override fun getItemCount(): Int = list.size


}

