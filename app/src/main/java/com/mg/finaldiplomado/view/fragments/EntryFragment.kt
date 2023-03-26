package com.mg.finaldiplomado.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isInvisible
import androidx.fragment.app.commit
import com.google.firebase.auth.FirebaseAuth
import com.mg.finaldiplomado.R
import com.mg.finaldiplomado.databinding.FragmentEntryBinding
import com.mg.finaldiplomado.view.activities.MenuActivity


class EntryFragment : Fragment(R.layout.fragment_entry) {

    private lateinit var binding: FragmentEntryBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEntryBinding.bind(view)
        setup()
    }

    private fun setup() {
        binding.progressBar.isInvisible = true
        binding.forgotTv.setOnClickListener {
            forgotTvAction()
        }
        binding.loginEntryTv.setOnClickListener {
            loginEntryTvAction()
        }
        binding.entryBtn.setOnClickListener {
            binding.progressBar.isInvisible = false
            entryBtnAction()
        }
    }

    private fun entryBtnAction() {
        if(binding.emailInput.text.isNotEmpty() && binding.passwordInput.text.isNotEmpty()){
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(binding.emailInput.text.toString(), binding.passwordInput.text.toString()).addOnCompleteListener{
                    if (it.isSuccessful){
                        val nextScreen = Intent(context, MenuActivity::class.java)
                        binding.progressBar.isInvisible = true
                        startActivity(nextScreen)
                    }else{
                        binding.progressBar.isInvisible = true
                        showAlert()
                    }
                }
        }else{
            binding.progressBar.isInvisible = true
            Toast.makeText(context,"Favor de llenar todos los campos", Toast.LENGTH_SHORT).show()
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

    private fun showAlert() {
        val builder = context?.let { AlertDialog.Builder(it) }
        builder?.setTitle("Error")
        builder?.setMessage("Verifiique si su usuario o contraseña son correctos")
        builder?.setPositiveButton("Aceptar", null)
        builder?.create()?.show()
    }
}