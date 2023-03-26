package com.mg.finaldiplomado.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.mg.finaldiplomado.R
import com.mg.finaldiplomado.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
    }

}