package com.mg.finaldiplomado.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mg.finaldiplomado.R
import com.mg.finaldiplomado.databinding.CardProductBinding
import com.mg.finaldiplomado.helpers.ProductClick
import com.mg.finaldiplomado.model.enties.Product
import com.squareup.picasso.Picasso

class AdapterProduct(private var product: ArrayList<Product>, private val ProductClick: ProductClick) : RecyclerView.Adapter<AdapterProduct.ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = CardProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ProductViewHolder, i: Int) {
        holder.bind(product[i])
        holder.itemView.setOnClickListener{
            ProductClick.productsClickListener(product[i])
        }
    }

    override fun getItemCount(): Int = product.size

    class ProductViewHolder(val binding: CardProductBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(product: Product) {
            binding.itemName.text = product.name
            Picasso.get()
                .load(product.photo)
                .placeholder(R.drawable.error)
                .error(R.drawable.error)
                .into(binding.itemImage)
        }
    }

    fun updateItems(newItems: ArrayList<Product>) {
        product.clear()
        product.addAll(newItems)
        notifyDataSetChanged()
    }
}