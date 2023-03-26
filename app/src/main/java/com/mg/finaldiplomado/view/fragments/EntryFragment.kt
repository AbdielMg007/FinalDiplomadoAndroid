package com.mg.finaldiplomado.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.mg.finaldiplomado.R
import com.mg.finaldiplomado.databinding.FragmentEntryBinding
import com.mg.finaldiplomado.databinding.FragmentForgotpassBinding
import com.mg.finaldiplomado.view.activities.MenuActivity


class EntryFragment : Fragment(R.layout.fragment_entry) {

    private lateinit var binding: FragmentEntryBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEntryBinding.bind(view)
        binding.forgotTv.setOnClickListener {
            forgotTvAction()
        }
        binding.loginEntryTv.setOnClickListener {
            loginEntryTvAction()
        }
        binding.entryBtn.setOnClickListener {
            val nextScreen = Intent(context, MenuActivity::class.java)
            startActivity(nextScreen)
        }

    }

    private fun loginEntryTvAction() {
        requireActivity().supportFragmentManager.commit {
            replace(R.id.fragmentLogin, CreateAccountFragment())
            addToBackStack(null)
        }
    }

    private fun forgotTvAction() {
        requireActivity().supportFragmentManager.commit {
            replace(R.id.fragmentLogin, ForgotPassFragment())
            addToBackStack(null)
        }
    }
}