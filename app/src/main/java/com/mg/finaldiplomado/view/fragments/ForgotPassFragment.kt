package com.mg.finaldiplomado.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.mg.finaldiplomado.R
import com.mg.finaldiplomado.databinding.FragmentForgotpassBinding


class ForgotPassFragment : Fragment(R.layout.fragment_forgotpass) {

    private lateinit var binding: FragmentForgotpassBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForgotpassBinding.bind(view)
    }
}