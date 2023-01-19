package com.example.countries.presentation.screens.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.countries.data.entity.CountriesInfoItem

class CountriesDiffUtil(
    private val oldList: List<CountriesInfoItem>,
    private val newList: List<CountriesInfoItem>
) : DiffUtil.Callback() {


    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem == newItem
    }
}