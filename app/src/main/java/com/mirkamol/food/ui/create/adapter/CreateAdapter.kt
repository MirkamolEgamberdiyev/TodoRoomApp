package com.mirkamol.food.ui.create.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.food.databinding.CreateItemBinding
import com.mirkamol.food.data.local.entity.Food

class CreateAdapter : ListAdapter<Food, CreateAdapter.Vh>(MyDiffUtil()) {
    inner class Vh(
        private var binding: CreateItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(food: Food) {
            binding.apply {
                foodNameTxt.text = "Food name:  " + food.foodName
                qualityTxt.text = "Food quantity:  " + food.quantity
                priceTxt.text = "Food price:  " + food.price + " sum"
            }
        }
    }
    class MyDiffUtil : DiffUtil.ItemCallback<Food>() {
        override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem.id == newItem.id

        }

        override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            CreateItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position))
    }
}