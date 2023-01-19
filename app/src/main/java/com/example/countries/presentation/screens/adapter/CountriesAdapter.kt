package com.example.countries.presentation.screens.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.R
import com.example.countries.data.entity.CountriesInfoItem
import com.example.countries.databinding.CountyItemBinding
import com.squareup.picasso.Picasso

class CountriesAdapter : RecyclerView.Adapter<CountriesAdapter.CountryViewHolder>() {
    var onCountriesItemClickListener: ((CountriesInfoItem) -> Unit)? = null

    var countryList = listOf<CountriesInfoItem>()
        set(value) {
            val callback = CountriesDiffUtil(countryList, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    class CountryViewHolder(view: CountyItemBinding) : RecyclerView.ViewHolder(view.root) {
        val binding = CountyItemBinding.bind(view.root)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CountryViewHolder(
        CountyItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        bind(holder.binding, countryList[position])
    }

    override fun getItemCount() = countryList.size

    private fun bind(binding: CountyItemBinding, country: CountriesInfoItem) {
        binding.root.setOnClickListener { onCountriesItemClickListener?.invoke(country) }
        binding.nameText.text = country.name
        Picasso.get()
            .load(country.flags.png)
            .error(R.drawable.ic_launcher_foreground)
            .into(binding.flagImage)
    }
}