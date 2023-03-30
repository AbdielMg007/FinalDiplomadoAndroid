package com.mg.finaldiplomado.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import com.mg.finaldiplomado.R
import com.mg.finaldiplomado.databinding.FragmentProductBinding
import com.mg.finaldiplomado.model.enties.Product
import com.squareup.picasso.Picasso

class ProductFragment : Fragment(R.layout.fragment_product) {

    private lateinit var binding: FragmentProductBinding

    private var name: String? = "Name"
    private var photo: String? = "Photo"
    private var price: String? = "Price"
    private var details: String? = "Details"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        name = requireArguments().getString(NAME)
        photo = requireArguments().getString(PHOTO)
        price = requireArguments().getString(PRICE)
        details = requireArguments().getString(DETAIL)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProductBinding.bind(view)
        setup()
    }

    private fun setup() {
        binding.toolbarTitle.text = name
        binding.tvName.text = "Tipo de producto: $name"
        binding.tvPrice.text = "Precio: $price"
        binding.tvDetails.text = details
        Picasso.get()
            .load(photo)
            .placeholder(R.drawable.error)
            .error(R.drawable.error)
            .into(binding.iPhoto)
        binding.toolbarReturned.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    companion object{
        private const val NAME = "Name"
        private const val PHOTO = "Foto"
        private const val PRICE = "Price"
        private const val DETAIL = "Detail"


        fun newInstance(product: Product) = ProductFragment().apply {
            arguments = bundleOf(NAME to product.name, PHOTO to product.photo, PRICE to product.price.toString(), DETAIL to product.detail)
        }

    }
}