package com.mg.finaldiplomado.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mg.finaldiplomado.R
import com.mg.finaldiplomado.databinding.PublicationCardBinding
import com.mg.finaldiplomado.helpers.enties.Publication
import com.squareup.picasso.Picasso

class AdapterPublication(private var publication: ArrayList<Publication>) : RecyclerView.Adapter<AdapterPublication.PublicationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublicationViewHolder {
        val binding = PublicationCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PublicationViewHolder(binding)
    }



    override fun onBindViewHolder(holder: PublicationViewHolder, i: Int) {
        holder.bind(publication[i])
    }

    override fun getItemCount(): Int = publication.size

    class PublicationViewHolder(val binding: PublicationCardBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(publication: Publication) {
            Picasso.get().load(publication.photo).placeholder(R.drawable.error).error(R.drawable.error).into(binding.photoImg)
            binding.footerTv.text = publication.footer
            binding.authorTv.text = publication.author
            binding.dateTv.text = publication.date
        }
    }

    fun updateItems(newItems: ArrayList<Publication>) {
        publication.clear()
        publication.addAll(newItems)
        notifyDataSetChanged()
    }
}