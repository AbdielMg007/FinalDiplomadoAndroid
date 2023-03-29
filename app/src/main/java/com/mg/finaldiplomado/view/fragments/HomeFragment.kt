package com.mg.finaldiplomado.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mg.finaldiplomado.R
import com.mg.finaldiplomado.databinding.FragmentHomeBinding
import com.mg.finaldiplomado.view.adapters.AdapterPublication
import com.mg.finaldiplomado.viewmodel.PublicationsViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val publicationViewModel: PublicationsViewModel by viewModels()
    private lateinit var adapter: AdapterPublication

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        setup()
    }

    private fun setup() {
        adapter = AdapterPublication(arrayListOf())

        binding.recyclerHome.layoutManager = LinearLayoutManager(context)
        binding.recyclerHome.adapter = adapter

        publicationViewModel.list.observe(viewLifecycleOwner) { newPublications ->
            adapter.updateItems(newPublications)
        }
    }

}