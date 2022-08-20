package com.mirkamol.food.ui.foods.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.food.data.local.entity.Food
import com.mirkamol.food.data.local.entity.HistoryModel
import com.mirkamol.food.databinding.HistoryItemBinding

class FoodsAdapter : ListAdapter<Food, FoodsAdapter.Vh>(MyDiffUtil()) {
    lateinit var itemCLick: ((Food) -> Unit)

    inner class Vh(
        private var itemHistoryBinding: HistoryItemBinding
    ) :
        RecyclerView.ViewHolder(itemHistoryBinding.root) {

        fun onBind(food: Food) {
            itemHistoryBinding.apply {
                tvName.text = "foodname:  "+food.foodName
                tvQuantity.text = "food quantity:  "+food.quantity
                tvPrice.text = "food price:  "+food.price
                tvKfName.text = "kafeName:   "+food.kafeName
                tvCount.text = "countPerson:   "+food.countPerson

                itemHistoryBinding.itemCard.setOnClickListener {
                    itemCLick.invoke(food)
                }
            }
        }
    }

    class MyDiffUtil : DiffUtil.ItemCallback<Food>() {
        override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem.foodName == newItem.foodName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            HistoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position))
    }
}