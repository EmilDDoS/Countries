package com.example.countries.presentation.screens.countries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.countries.R
import com.example.countries.databinding.FragmentCountriesBinding
import com.example.countries.di.ViewModelFactory
import com.example.countries.presentation.screens.adapter.CountriesAdapter


class CountriesFragment : Fragment() {
    companion object {
        const val KEY_INFO = "Info"
    }

    private lateinit var binding: FragmentCountriesBinding
    private val viewModel: CountriesViewModel by viewModels { ViewModelFactory() }
    private val adapter = CountriesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCountriesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.countriesRecyclerView.adapter = adapter
        setListeners()
        subscribe()
        viewModel.update()
    }

    private fun setListeners() {
        adapter.onCountriesItemClickListener = {
            val bundle = Bundle().apply { putParcelable(KEY_INFO, it) }
            requireActivity().findNavController(R.id.nav_host)
                .navigate(R.id.action_countriesFragment_to_detailsFragment, bundle)
        }

        binding.updateButton.setOnClickListener { viewModel.update() }
    }

    private fun subscribe() {
        lifecycleScope.launchWhenCreated {
            viewModel.countriesInfo.collect {
                when (it) {
                    is CountriesViewModel.LoadState.Success -> {
                        adapter.countryList = it.data
                    }
                    is CountriesViewModel.LoadState.Error -> {
                        Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

}