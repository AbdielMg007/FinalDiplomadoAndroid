package com.mg.finaldiplomado.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.mg.finaldiplomado.R
import com.mg.finaldiplomado.databinding.ActivitySettingsBinding
import com.mg.finaldiplomado.view.fragments.HomeFragment
import com.mg.finaldiplomado.view.fragments.InfoFragment
import com.mg.finaldiplomado.view.fragments.ProfileFragment


class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    var isFabOpen = false

    override fun onResume() {
        super.onResume()
        Log.i("xd","xd")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(ProfileFragment())
        setup()
    }

    private fun setup() {
        binding.apps.setOnClickListener {
            if (isFabOpen)
                closeFab()
            else
                showFab()
        }

        binding.profile.setOnClickListener{
            replaceFragment(ProfileFragment())
            closeFab()
        }

        binding.info.setOnClickListener{
            replaceFragment(InfoFragment())
            closeFab()
        }

        binding.logOut.setOnClickListener {
            Firebase.auth.signOut()
            finish()
        }

    }

    fun showFab(){
        isFabOpen = true
        binding.apps.setImageResource(R.drawable.vector_close)
        binding.profile.animate().translationY(-540F)
        binding.info.animate().translationY(-360F)
        binding.logOut.animate().translationY(-180F)
    }

    fun closeFab(){
        isFabOpen = false
        binding.apps.setImageResource(R.drawable.vector_apps)
        binding.profile.animate().translationY(0F)
        binding.info.animate().translationY(0F)
        binding.logOut.animate().translationY(0F)
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentMager = supportFragmentManager
        val fragmentTrasaction = fragmentMager.beginTransaction()
        fragmentTrasaction.replace(R.id.fragmentSet, fragment)
        fragmentTrasaction.commit()
    }
}