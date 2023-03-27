package com.mg.finaldiplomado.view.activities

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.core.graphics.ColorUtils
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.mg.finaldiplomado.R
import com.mg.finaldiplomado.databinding.ActivityMenuBinding
import com.mg.finaldiplomado.view.fragments.HomeFragment
import com.mg.finaldiplomado.view.fragments.ShopFragment

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
        setup()
    }

    private fun setup() {

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homeNav -> replaceFragment(HomeFragment())
                R.id.shoppingNav -> replaceFragment(ShopFragment())
                R.id.settingsNav -> availableAccount()


                else ->{

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentMager = supportFragmentManager
        val fragmentTrasaction = fragmentMager.beginTransaction()
        fragmentTrasaction.replace(R.id.fragmentNav, fragment)
        fragmentTrasaction.commit()
    }

    private fun availableAccount(){
        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null) {
            val nextScreen = Intent(this, SettingsActivity::class.java)
            startActivity(nextScreen)
        } else {
            val returnLogin = Intent(this, LoginActivity::class.java)
            startActivity(returnLogin)
            finish()
            Toast.makeText(applicationContext,"Inicia sesion para acceder a este apartado",Toast.LENGTH_SHORT).show()
        }
    }

}