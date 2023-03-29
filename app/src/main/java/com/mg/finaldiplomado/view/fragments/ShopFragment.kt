package com.mg.finaldiplomado.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mg.finaldiplomado.R
import com.mg.finaldiplomado.databinding.FragmentShopBinding
import com.mg.finaldiplomado.helpers.ProductClick
import com.mg.finaldiplomado.model.enties.Product
import com.mg.finaldiplomado.view.adapters.AdapterProduct
import com.mg.finaldiplomado.viewmodel.ProductsViewModel


class ShopFragment : Fragment(R.layout.fragment_shop), ProductClick {
    private lateinit var binding: FragmentShopBinding
    private val productsViewModel: ProductsViewModel by viewModels()
    private lateinit var adapter: AdapterProduct

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShopBinding.bind(view)
        setup()
    }

    private fun setup() {
        adapter = AdapterProduct(arrayListOf(), this)

        binding.recyclerShop.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerShop.adapter = adapter

        productsViewModel.list.observe(viewLifecycleOwner) { newPublications ->
            adapter.updateItems(newPublications)
        }
    }

    override fun productsClickListener(Product: Product) {
        Toast.makeText(context,"Si sirve",Toast.LENGTH_SHORT).show()
    }
}