package com.example.countries.presentation.screens.details

import android.graphics.Region
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.createBitmap
import com.example.countries.R
import com.example.countries.data.entity.CountriesInfoItem
import com.example.countries.databinding.FragmentDetailsBinding
import com.example.countries.presentation.screens.countries.CountriesFragment.Companion.KEY_INFO
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val info = arguments?.get(KEY_INFO) as CountriesInfoItem
        with(binding){
            name.text = "Name: " + info.name
            capital.text = "Capital: "+info.capital
            regionalbloc.text = "Region: " + info.region
            currencies.text = "Currencies: " + info.currencies.first().name
            timezones.text = "Timezones: " + info.timezones.toString()
            Picasso.get()
                .load(info.flags.png)
                .error(R.drawable.ic_launcher_foreground)
                .into(binding.flag)
        }
    }
}