package com.mg.finaldiplomado.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mg.finaldiplomado.R
import com.mg.finaldiplomado.databinding.FragmentCreateAccountBinding
import com.mg.finaldiplomado.databinding.FragmentEntryBinding
import com.mg.finaldiplomado.view.activities.MenuActivity


class CreateAccountFragment : Fragment(R.layout.fragment_create_account) {
    private lateinit var binding: FragmentCreateAccountBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreateAccountBinding.bind(view)

        binding.entry2Btn.setOnClickListener {
            val nextScreen = Intent(context, MenuActivity::class.java)
            startActivity(nextScreen)
        }
    }
}