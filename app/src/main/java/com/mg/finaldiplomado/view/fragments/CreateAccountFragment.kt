package com.mg.finaldiplomado.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isInvisible
import com.google.firebase.auth.FirebaseAuth
import com.mg.finaldiplomado.R
import com.mg.finaldiplomado.databinding.FragmentCreateaccountBinding
import com.mg.finaldiplomado.view.activities.MenuActivity


class CreateAccountFragment : Fragment(R.layout.fragment_createaccount) {
    private lateinit var binding: FragmentCreateaccountBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreateaccountBinding.bind(view)
        setup()
    }

    private fun setup() {
        binding.progressBarCreateAccount.isInvisible = true
        binding.entryBtn.setOnClickListener {
            binding.progressBarCreateAccount.isInvisible = false
            entryBtnAction()
        }
        binding.entry2Btn.setOnClickListener {
            entry2BtnAction()
        }
    }

    private fun entryBtnAction() {
        if(binding.emailInput.text.isNotEmpty() && binding.passwordInput.text.isNotEmpty()){
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(binding.emailInput.text.toString(), binding.passwordInput.text.toString()).addOnCompleteListener{
                    if (it.isSuccessful){
                        val nextScreen = Intent(context, MenuActivity::class.java)
                        binding.progressBarCreateAccount.isInvisible = true
                        startActivity(nextScreen)
                    }else{
                        binding.progressBarCreateAccount.isInvisible = true
                        showAlert()
                    }
                }
        }else{
            binding.progressBarCreateAccount.isInvisible = true
            Toast.makeText(context,"Favor de llenar todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun entry2BtnAction() {
        val nextScreen = Intent(context, MenuActivity::class.java)
        startActivity(nextScreen)
    }
    private fun showAlert() {
        val builder = context?.let { AlertDialog.Builder(it) }
        builder?.setTitle("Error")
        builder?.setMessage("Se ha generado un error al crear la cuenta")
        builder?.setPositiveButton("Aceptar", null)
        builder?.create()?.show()
    }
}