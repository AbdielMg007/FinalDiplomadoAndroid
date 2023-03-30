package com.mg.finaldiplomado.view.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.mg.finaldiplomado.R
import com.mg.finaldiplomado.databinding.FragmentForgotpassBinding


class ForgotPassFragment : Fragment(R.layout.fragment_forgotpass) {

    private lateinit var binding: FragmentForgotpassBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForgotpassBinding.bind(view)
        setup()
    }

    private fun setup() {
        binding.entryForgotBtn.setOnClickListener{
            if(binding.emailForgotInput.text.isNotEmpty()){
                FirebaseAuth.getInstance().sendPasswordResetEmail(binding.emailForgotInput.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(context,"Se ah enviado un correo para restablecer su contraseña", Toast.LENGTH_SHORT).show()
                        requireActivity().supportFragmentManager.popBackStack()
                    }
                    else
                        Toast.makeText(context,"Ah ocurrido un error, revise si el correo es autentico", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(context,"Ingrese su correo", Toast.LENGTH_SHORT).show()
            }

        }
    }
}